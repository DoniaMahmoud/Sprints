import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ViewStoreViewersController implements I_SystemMessages , I_UserInputs, I_ReturnIntChoices{

	private StoreOwner s=new StoreOwner();
	private String storename;
	
	public ViewStoreViewersController() {
		this.storename="";
		this.s=null;
	}
	
	public ViewStoreViewersController(StoreOwner s) {
		this.storename="";
		this.s=s;
	}
	
	
	public void setStorename(String st) {
		this.storename=st;
	}
	
	@Override
	public void messages() {
		System.out.println("Enter the store name you want to view its viewing stats: ");
	}

	
	@Override
	public void getUserInputs() throws IOException {
		Scanner n=new Scanner(System.in);
		setStorename(n.next());
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
				s.PrintViewStats(0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 else {
			 UpdateStats u=new UpdateStoreViewsController(this.storename);
			 try {
				 s.PrintViewStats(u.getCount());
				 return u.getCount();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
		 return 0;
	}


	public boolean CheckExistence() {
		String filename=this.storename+"Viewer.txt";
		File f=new File(filename);
		if(!f.exists()) {
			return false;
		}
		else
			return true;
	}


}
