import java.util.Scanner;

public class Usernames  implements I_SystemMessages , I_UserInputs, I_ReturnStringChoices {

    private String username;
	
	
	public void set_Username(String c) {
		this.username=c;
	}

	
	@Override
	public void messages() {
		System.out.println("Enter your username:");	
	}

	
	@Override
	public void getUserInputs() {
		Scanner s=new Scanner(System.in);
		set_Username(s.next());	
	}

	
	@Override
	public String Get_choice() {
		getUserInputs();
		return this.username;
	}




	
	
}
