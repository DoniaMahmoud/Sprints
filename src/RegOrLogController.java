import java.util.Scanner;

public class RegOrLogController implements I_UserInputs, I_SystemMessages, I_ReturnIntChoices {

	private int choice;
	
	
	public void set_choice(int c) {
		this.choice=c;
	}
	
	@Override
	public void messages() {
		System.out.println("Press 1 to Register");
		System.out.println("Press 2 to Login");
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
