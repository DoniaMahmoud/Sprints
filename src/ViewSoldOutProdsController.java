import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewSoldOutProdsController  implements I_SystemMessages , I_UserInputs, I_ReturnIntChoices{
	private StoreOwner s=new StoreOwner();
	private String storename;
	
	public ViewSoldOutProdsController() {
		this.storename="";
		this.s=null;
	}
	
	public ViewSoldOutProdsController(StoreOwner s) {
		this.storename="";
		this.s=s;
	}
	
	
	public void setStorename(String st) {
		this.storename=st;
	}
	
	@Override
	public void messages() {
		System.out.println("Enter the store name you want to view its Sold out products: ");
	}

	
	@Override
	public void getUserInputs() throws IOException {
		Scanner s=new Scanner(System.in);
		setStorename(s.next());
		if(Database.searchstores(this.s,this.storename)==false) {
			System.out.println("You don't have a store with this name!");
			System.exit(1);
		}
	}
	

	@Override
	public int get_choice() {
		 try {
			getUserInputs();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 String filename=this.storename+".txt";
		 ArrayList <Products> products=new ArrayList<Products>();
		 I_ReadProdsFromFiles f= new ReadStoreProdsController();
		 try {
			products=f.readProds(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 getSoldout(products);
		 return 0;
	}


	public void getSoldout(ArrayList<Products> p) {
		ArrayList<String>Pnames=new ArrayList<String>();
		for(int i=0; i<p.size(); i++) {
			if(p.get(i).get_amount()==0) {
				Pnames.add(p.get(i).get_name());
			}
		}
		s.PrinttSoldout(Pnames);
	}

	
	
}
