import java.io.IOException;
import java.util.Scanner;

public class CustomerExeController implements I_UserExecution, I_SystemMessages, I_UserInputs{

	private Customer c=new Customer();
	private int choice;
	
	public CustomerExeController(Customer cust){
		this.c=cust;
	}
	
	public void SetChoice(int c) {
		this.choice=c;
	}
	
	@Override
	public void messages() {
		 System.out.println("1-Buy Products");
		 System.out.println("2-Logout");
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
		if(this.choice==1) {
			s=new CustomerStoreChoiceController(this.c);
			s.messages();
			System.out.println("Product bought Successfully!");
			ExecuteUser();
		}
		else if(this.choice==2) {
			System.out.println("Successful Logout");
			return;
		}
		
		
	}

	

	
}
