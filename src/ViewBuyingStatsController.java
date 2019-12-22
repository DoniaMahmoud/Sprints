import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ViewBuyingStatsController implements I_SystemMessages , I_UserInputs, I_ReturnIntChoices{

	private StoreOwner s=new StoreOwner();
	private String storename;
	
	public ViewBuyingStatsController() {
		this.storename="";
		this.s=null;
	}
	
	public ViewBuyingStatsController(StoreOwner s) {
		this.storename="";
		this.s=s;
	}
	
	
	public void setStorename(String st) {
		this.storename=st;
	}
	
	@Override
	public void messages() {
		System.out.println("Enter the store name you want to view its Buying stats: ");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(CheckExistence()==false) {
			 try {
				s.PrintStats(0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 else {
			 UpdateStats u=new UpdateBuyingStatsController(this.storename);
			 try {
				 s.PrintStats(u.getCount());
				 return u.getCount();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
		 return 0;
	}


	public boolean CheckExistence() {
		String filename=this.storename+"BuyingStats.txt";
		File f=new File(filename);
		if(!f.exists()) {
			return false;
		}
		else
			return true;
	}


}
