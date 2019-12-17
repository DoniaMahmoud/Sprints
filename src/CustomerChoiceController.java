import java.io.IOException;
import java.util.Scanner;

public class CustomerChoiceController implements I_SystemMessages , I_UserInputs, I_ReturnIntChoices{

	private int choice;
	
	
	public void set_choice(int c) {
		this.choice=c;
	}
	
	@Override
	public void messages() {
		System.out.println("Enter 1 if you want to view Online stores or 2 to view Onsite ones: ");
		
	}
	
	@Override
	public void getUserInputs() throws IOException {
		Scanner s=new Scanner(System.in);  
		set_choice(s.nextInt());
	}
	
	@Override
	public int get_choice() {
		try {
			getUserInputs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.choice;
	}


	

}
