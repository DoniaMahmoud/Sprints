import java.util.Scanner;

public class IdentifyLoginMessagesController implements I_SystemMessages , I_UserInputs, I_ReturnIntChoices{

	private int choice;
	
	
	public void set_choice(int c) {
		this.choice=c;
	}
	
	@Override
	public void messages() {
		System.out.println("1-Login as Customer ");
		System.out.println("2-Login as Adminstrator ");
		System.out.println("3-Login as StoreOwner ");
		
	}

	@Override
	public void getUserInputs() {
		Scanner s=new Scanner(System.in);  
		set_choice(s.nextInt());
		//s.close();
	
	}
	
	
	@Override
	public int get_choice() {
		this.getUserInputs();
		return this.choice;
	}
	

}
