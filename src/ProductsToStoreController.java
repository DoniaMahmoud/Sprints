import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductsToStoreController implements I_SystemMessages, I_UserInputs{

	private StoreOwner owner=new StoreOwner();
	private String storename="";
	private ArrayList<Products>list=new ArrayList<Products>();
	
	public ProductsToStoreController() {
		this.owner=null;
	}

	
	public ProductsToStoreController(StoreOwner o) {
		this.owner=o;
	}
	
	public ProductsToStoreController(ArrayList<Products> p) {
		this.list=p;
	}
	
	public ProductsToStoreController(StoreOwner o,ArrayList<Products> p,String name) {
		this.owner=o;
		this.list=p;
		this.storename=name;
	}
	

	
	@Override
	public void messages() {
		System.out.println("Here is the list of products available on the plateform: " );
		for(int i=0; i<this.list.size(); i++ ) {
			System.out.print("Product Name: ");
			System.out.println(this.list.get(i).get_name());
			System.out.print("Product SerialNo: ");
			System.out.println(this.list.get(i).get_SerialNo());
			System.out.print("Category: ");
			System.out.println(this.list.get(i).get_category());
			System.out.print("Type: ");
			System.out.println(this.list.get(i).get_type());
			System.out.print("Price: ");
			System.out.println(this.list.get(i).get_price());
		}
		System.out.println("Enter the serial number of the product you want to add to you store or press 0 to stop");
	}

	
	@Override
	public void getUserInputs() throws IOException {
		Scanner r=new Scanner(System.in);
		int serial=r.nextInt();
		if(serial==0) {
			System.exit(1);
		}
		else {
			CheckSerial(serial);
		}
	}
	
	
	public void CheckSerial(int serial) throws IOException {
		Scanner n=new Scanner(System.in);
		Products p=new Products();
		for(int i=0; i<this.list.size(); i++) {
			if(serial==this.list.get(i).get_SerialNo()) {
				System.out.println("Enter the amount you want: ");
				int amount=n.nextInt();
				Brands m= ValidateBrandAssign();
				p=new Products(this.list.get(i).get_name(),
						this.list.get(i).get_SerialNo(),
						this.list.get(i).get_category(),
						this.list.get(i).get_type(),
						m,
						this.list.get(i).get_price(),
						amount);
				SendProdToAdd(p,this.storename);
				break;	
	   }
			else 
				continue;
     }
 }
	
	
	public Brands ValidateBrandAssign() throws IOException {
		I_SystemMessages s=new AssignBrandsController();
		s.messages();
		I_BrandValidation v=new AssignBrandsController();
		Brands m=v.ValidateChosenBrand();
		while(m.getBrandName()=="" && m.getBrandCategory()=="") {
			System.out.println("Invalid BrandName.");
			m=v.ValidateChosenBrand();
	}
	return m;
}
	
	public void SendProdToAdd(Products p,String storename) throws IOException {
		this.owner.AddProductsToStore(p,storename);
	}

}