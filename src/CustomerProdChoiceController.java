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
		System.out.println("Please enter the serial no. of the product you want to buy: ");
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
		while(checkSerialValidity()==false) {
			messages();
		}
		return;
	}
	
	
	
	public boolean checkSerialValidity() throws IOException {
		for(int i=0; i<this.products.size(); i++) {
			if(this.products.get(i).get_SerialNo()==this.choice) {
				Products p=this.products.get(i);
				int index=i;
				I_SystemMessages s=new CustomerAmountChoiceController();
				s.messages();
				I_ReturnIntChoices r=new CustomerAmountChoiceController(p,this.c);
				int newAmount= this.products.get(i).get_amount()-r.get_choice();
				p.set_amount(newAmount);
				I_UpdateStoreProducts u=new UpdateProdsInFilesController();
				String filename=this.storename+".txt";
				u.UpdateFile(filename, this.products);
				return true;
			}
			else
				continue;
		}
		System.out.println("SerialNo. is invalid. Please try again: ");
		return false;
	}
	
	
	

	
	
	
}
