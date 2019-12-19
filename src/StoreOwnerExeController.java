import java.io.IOException;
import java.util.Scanner;

public class StoreOwnerExeController implements I_UserExecution , I_SystemMessages, I_UserInputs{

	private StoreOwner s=new StoreOwner();
	private int choice;
	
	public StoreOwnerExeController(StoreOwner s) {
		this.s=s;
	}
	
	
	public void SetChoice(int c) {
		this.choice=c;
	}
	
	@Override
	public void messages() {
		 System.out.println("1-Add Store: ");
		 System.out.println("2-Add Products: ");
		 System.out.println("3-Customer Viewing Statistics");
		 System.out.println("4-Logout");
		
	}
	
	@Override
	public void getUserInputs() throws IOException {
		Scanner s=new Scanner(System.in);
		SetChoice(s.nextInt());
		
	}
	
	@Override
	public void ExecuteUser() throws IOException {
		messages();
		getUserInputs();
		I_SystemMessages s;
		I_UserInputs u;
		if(this.choice==1) {
			s=new NewStoreController();
			s.messages();
			u=new NewStoreController(this.s);
			u.getUserInputs();
			ExecuteUser();
		}
		else if(this.choice==2) {
			s=new StoreValidationController();
			s.messages();
			u=new StoreValidationController(this.s);
			u.getUserInputs();
			System.out.println("Product added to your store successfully");
			ExecuteUser();
		}
		else if(this.choice==3) {
			s=new ViewStoreCounterController();
			s.messages();
			I_ReturnIntChoices r=new ViewStoreCounterController(this.s);
			r.get_choice();
			ExecuteUser();
		}
		else if(this.choice==4) {
			System.out.println("Successful Logout");
			return;
		}
		
		
	}

	
}
