import java.io.IOException;
import java.util.Scanner;

public class ViewStoreCounterController implements I_SystemMessages , I_UserInputs, I_ReturnIntChoices{

	private String storename;
	
	public ViewStoreCounterController() {
		this.storename="";
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
		 UpdateStoreViewsController u=new UpdateStoreViewsController(this.storename);
		 try {
			 return u.getCount();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return 0;
	}




}
