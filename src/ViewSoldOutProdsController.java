import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewSoldOutProdsController  implements I_SystemMessages , I_UserInputs, I_ReturnIntChoices{
	private StoreOwner s=new StoreOwner();
	private String storename;
	private ArrayList <String>Pnames=new ArrayList<String>();
	
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
			UpdateSoldOutStatsController u=new UpdateSoldOutStatsController(this.storename);
			u.Get_SoldOutStats();
			this.Pnames=u.getData();
			s.PrinttSoldout(this.Pnames);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return 0;
	}

	
	
}
