import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreValidationController implements I_SystemMessages, I_UserInputs{

	
	private StoreOwner owner=new StoreOwner();
	private ArrayList<Products>list=new ArrayList<Products>();
	
	public StoreValidationController() {
		this.owner=null;
	}

	
	public StoreValidationController(StoreOwner o) {
		this.owner=o;
	}
	
	public StoreValidationController(StoreOwner o,ArrayList<Products> p) {
		this.owner=o;
		this.list=p;
	}
	
	
	@Override
	public void messages() {
		System.out.println("Enter the store name you want to add products to: ");
		
	}
	
	@Override
	public void getUserInputs() throws IOException {
		Scanner s=new Scanner(System.in);
		String storename=s.next();
		sendName(storename);
		
	}
	

	public void sendName(String storename) throws IOException {
		if(Database.searchstores(this.owner, storename)) {
			if(this.owner.get_type().equals("online")){
				this.list=Products.get_OnlineProducts();
				I_SystemMessages s=new ProductsToStoreController(this.list);
				s.messages();
				I_UserInputs u=new ProductsToStoreController(this.owner,this.list,storename);
				u.getUserInputs();
			}
			else {
				this.list=Products.get_AllProducts();
				I_SystemMessages s=new ProductsToStoreController(this.list);
				s.messages();
				I_UserInputs u=new ProductsToStoreController(this.owner,this.list,storename);
				u.getUserInputs();
			}
		}
		else {
			System.out.println("You don't have a store with this name.");
			System.exit(1);
		}
	}
	

	

	

}