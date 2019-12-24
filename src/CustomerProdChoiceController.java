import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerProdChoiceController implements I_SystemMessages , I_UserInputs{

    private int choice;
    private String storename;
    private Customer c=new Customer();
	private ArrayList<Products>products=new ArrayList<Products>();

	public CustomerProdChoiceController() {
		this.products=null;
		this.c=null;
		this.choice=0;
		this.storename="";
	}
	
	public CustomerProdChoiceController(ArrayList<Products>p,String name,Customer c) {
		this.products=p;
		this.storename=name;
		this.c=c;
	}
	
	public void set_choice(int c) {
		this.choice=c;
	}
	
	
	
	@Override
	public void messages() {
		System.out.println("Here is the list of products in this store: ");
		for(int i=0; i<this.products.size(); i++) {
			System.out.println("ProductName: " + this.products.get(i).get_name());
			System.out.println("Serial: " + this.products.get(i).get_SerialNo());
			System.out.println("Category: " + this.products.get(i).get_category());
			System.out.println("Type: " + this.products.get(i).get_type());
			System.out.println("BrandName: " + this.products.get(i).get_Brand().getBrandName());
			System.out.println("BrandCategory: " + this.products.get(i).get_Brand().getBrandCategory());
			System.out.println("Price: " + this.products.get(i).get_price());
			System.out.println("Amount: " + this.products.get(i).get_amount());
		}
		System.out.println("Please enter the serial no. of the product you want to buy or 0 to stop: ");
		try {
			getUserInputs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public void getUserInputs() throws IOException {
		Scanner s=new Scanner(System.in);  
		set_choice(s.nextInt());
		if(this.choice==0) {
			System.exit(1);
		}
		else {
			while(checkSerialValidity()==false) {
				messages();
			}
			Database.create_StoreBuyingStatsPath(this.storename);
			Subject sub=new BuyingStatsSubject();
			Observer o=new UpdateBuyingStatsController(this.storename,sub);
			sub.DataChanged();
			return;
		}
		
	}
	
	
	
	public boolean checkSerialValidity() throws IOException {
		for(int i=0; i<this.products.size(); i++) {
			if(this.products.get(i).get_SerialNo()==this.choice) {
				I_Discount discount= new OriginalPrice(this.products.get(i).get_price());
				System.out.println("Original Price="+discount.getPrice());
				Products p=this.products.get(i);
				I_SystemMessages s=new CustomerAmountChoiceController();
				s.messages();
				I_ReturnIntChoices r=new CustomerAmountChoiceController(p,this.c);
				int newAmount= this.products.get(i).get_amount()-r.get_choice();		
				if(c.CheckIfStoreOwner() && c.FirstTimeToBuy() && TwoSameProductsStoreOwner(c.getUsername(),this.products.get(i).get_SerialNo()) ) {	
					 discount =new StoreOwnerDiscount(discount).getNewPrice();
                 	 discount = new FirstTimeToBuyDiscount(discount).getNewPrice();
					 discount = new TwoSameProductsDiscount(discount).getNewPrice();
					 System.out.println("Final Price="+discount.getPrice());
			}  
				else if(c.CheckIfStoreOwner() && c.FirstTimeToBuy()&& TwoSameProductsStoreOwner(c.getUsername(),this.products.get(i).get_SerialNo())==false) {
					 discount =new StoreOwnerDiscount(discount).getNewPrice();
					 discount = new FirstTimeToBuyDiscount(discount).getNewPrice();
					 System.out.println("Final Price="+discount.getPrice());
				}
				else if(c.CheckIfStoreOwner() &&TwoSameProductsStoreOwner(c.getUsername(),this.products.get(i).get_SerialNo())&&c.FirstTimeToBuy()==false) {	
					 discount =new StoreOwnerDiscount(discount).getNewPrice();
					 discount = new TwoSameProductsDiscount(discount).getNewPrice();
						System.out.println("Final Price="+discount.getPrice()); 
				}
				else if(c.CheckIfStoreOwner()==false && c.FirstTimeToBuy() && TwoSameProductsCustomer(this.products.get(i).get_SerialNo())) {	
					 discount = new FirstTimeToBuyDiscount(discount).getNewPrice();
						 discount = new TwoSameProductsDiscount(discount).getNewPrice();
							System.out.println("Final Price="+discount.getPrice());
				}
				p.set_amount(newAmount);
				Update();
				UpdateAmount();
				return true;
			}
			else
				continue;
		}
		System.out.println("SerialNo. is invalid. Please try again: ");
		return false;
	}
	
	
	
	public void Update() throws IOException {
		I_UpdateStoreProducts u=new UpdateProdsInFilesController();
		String filename=this.storename+".txt";
		u.UpdateFile(filename, this.products);
		Subject sub=new ProdsStatsSubject();
	    Observer o= new UpdateProdsStatsController(sub,this.storename);
        sub.DataChanged();
	}
	
	
	public void UpdateAmount() throws IOException{
		Subject sub=new SoldOutStatsSubject();
		Observer o=new UpdateSoldOutStatsController(this.storename,sub);
		sub.DataChanged();
	}


    public boolean TwoSameProductsCustomer(int serial) throws IOException {
    	ArrayList<Integer> amounts = new ArrayList<Integer>();
		String filename=this.storename+".txt";
		I_ReadProdsFromFiles file = new ReadStoreProdsController();
		products= file.readProds(filename);
		for (int i=0; i<products.size(); i++) {
			if(serial==products.get(i).get_SerialNo()) {
			if(products.get(i).get_amount()>=2) {
			
				return true;
			}
			}
		
		}
		  return false;
	}
    public boolean TwoSameProductsStoreOwner(String username,int serial) throws IOException {
    	ArrayList<Integer> amounts = new ArrayList<Integer>();
		String filename=username+"Purchase.txt";
		ReadProdsAddressController file = new ReadProdsAddressController();
		amounts= file.readProds(filename);
		for(int j=0; j<amounts.size(); j++) {
		for (int i=0; i<products.size(); i++) {
			if(serial==products.get(i).get_SerialNo()) {
			if(amounts.get(j)>=2) {
				return true;
			}
			}
		}
		}
		  return false;
	}
    
	
	
	
}
