import java.util.Scanner;

public class Passwords  implements I_SystemMessages , I_UserInputs, I_ReturnStringChoices {
	
private String password;
	
	
	public void set_Password(String c) {
		this.password=c;
	}

	
	@Override
	public void messages() {
		System.out.println("Enter your password:");	
	}

	
	@Override
	public void getUserInputs() {
		Scanner s=new Scanner(System.in);
		set_Password(s.next());		
	}

	
	@Override
	public String Get_choice() {
		getUserInputs();
		return this.password;
	}


}
