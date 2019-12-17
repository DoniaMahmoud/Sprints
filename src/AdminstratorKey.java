import java.util.Scanner;

public class AdminstratorKey implements I_SystemMessages , I_UserInputs, I_ReturnIntChoices{

private int key;
	
	public void set_Type(int c) {
		this.key=c;
	}
	
	@Override
	public void messages() {
		System.out.println("Enter the adminstrator verification key:");	
	}

	
	@Override
	public void getUserInputs() {
		Scanner s=new Scanner(System.in);
		set_Type(s.nextInt());
	}

	
	@Override
	public int get_choice() {
		getUserInputs();
		return this.key;
	}

}
