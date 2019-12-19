import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ViewStoreCounterController implements I_SystemMessages , I_UserInputs, I_ReturnIntChoices{

	private StoreOwner s=new StoreOwner();
	private String storename;
	
	public ViewStoreCounterController() {
		this.storename="";
		this.s=null;
	}
	
	public ViewStoreCounterController(StoreOwner s) {
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
		Scanner s=new Scanner(System.in);
		setStorename(s.next());
		
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
				s.CustViewiStats(0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 else {
			 UpdateStoreViewsController u=new UpdateStoreViewsController(this.storename);
			 try {
				 s.CustViewiStats(u.getCount());
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
