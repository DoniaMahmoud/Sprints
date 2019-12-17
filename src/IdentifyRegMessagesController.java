import java.util.Scanner;

public class IdentifyRegMessagesController implements I_SystemMessages , I_UserInputs, I_ReturnIntChoices{

	private int choice;
	
	
	public void set_choice(int c) {
		this.choice=c;
	}
	
	@Override
	public void messages() {
		System.out.println("1-Register as Customer ");
		System.out.println("2-Register as Adminstrator ");
		System.out.println("3-Register as StoreOwner ");
	}

	@Override
	public void getUserInputs() {
		Scanner s=new Scanner(System.in);  
		set_choice(s.nextInt());
	
	}
	
	
	@Override
	public int get_choice() {
		getUserInputs();
		return this.choice;
	}
	

}
