import java.io.IOException;
import java.util.Scanner;

public class NewStoreController implements I_SystemMessages, I_UserInputs{

	
	private StoreOwner owner=new StoreOwner();
	
	public NewStoreController() {
		this.owner=null;
	}
	
	public NewStoreController(StoreOwner s) {
		this.owner=s;
	}
	
	@Override
	public void messages() {
		System.out.println("Enter your new store name,category and its address if it's an onsite store: ");
	}
	
	@Override
	public void getUserInputs() throws IOException {
		Scanner s=new Scanner(System.in);
		if(StoreOwner.get_type().equals("online")) {
			String Name=s.next();
			String Category=s.next();
			Stores st=new OnlineStores(Name,Category);
			sendStoreData(st);
		}
		else {
			String Name=s.next();
			String Category=s.next();
			String address=s.next();
			Stores st=new OnsiteStores(Name,Category,address);
			sendStoreData(st);
		}
	}
	

	public void sendStoreData(Stores s) throws IOException {
		this.owner.addStore(s);
	}



}
