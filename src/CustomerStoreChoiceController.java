import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerStoreChoiceController implements I_SystemMessages , I_UserInputs, I_ReturnStringChoices {

    private String choice;
    private Stores s;
    private Customer c=new Customer();
    private ArrayList<Stores> stores=new ArrayList<Stores>();
	
    public CustomerStoreChoiceController(Customer c) {
    	this.c=c;
    }
    
	public void set_choice(String c) {
		this.choice=c;
	}
	
	public void getStoreType() throws IOException {
		I_SystemMessages s=new CustomerChoiceController();
		s.messages();
		I_ReturnIntChoices r=new CustomerChoiceController();
		int c=r.get_choice();
		getStoresList(c);
	}
	
	
	public void getStoresList(int c) throws IOException {
		if(c==1) {
			this.s=new OnlineStores();
			this.stores=s.getStores();
		}
		else {
			this.s=new OnsiteStores();
			this.stores=s.getStores();
		}
	}
	
	
	@Override
	public void messages() {
		try {
			getStoreType();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Here is a list of stores available.");
		for(int i=0; i<this.stores.size(); i++) {
			System.out.println(this.stores.get(i).getStore_Name());
		}	
		System.out.println("Please enter the store name you want to view products from: ");
		Get_choice();
	}
	
	
	@Override
	public void getUserInputs() {
		Scanner s=new Scanner(System.in);  
		set_choice(s.next());
		this.s.setStore_Name(this.choice);
	}
	

	@Override
	public String Get_choice() {
		getUserInputs();
		while(validateStoreName()==false) {
			System.out.println("Storename is invalid. Please try again");
			messages();
		}
		try {
			Database.create_StoreViewerPath(this.choice);
			System.out.println("1");
			UpdateStoreViewsController u= new UpdateStoreViewsController(this.choice);
			u.updateCounter();
			System.out.println("1");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			getChosenStoreProds();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.choice;
	}
	
	
	public boolean validateStoreName() {
		for(int i=0; i<this.stores.size(); i++) {
			if(this.choice.equals(stores.get(i).getStore_Name())){
				return true;
			}
			else
				continue;
		}
		return false;
	}
	
	
	public void getChosenStoreProds() throws IOException {
		I_SystemMessages s=new CustomerProdChoiceController(this.s.get_StoreProducts(),this.choice,this.c);
		s.messages();
	}
	

}