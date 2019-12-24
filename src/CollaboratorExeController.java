import java.io.IOException;
import java.util.Scanner;

public class CollaboratorExeController implements I_UserExecution, I_SystemMessages, I_UserInputs{

	private Collaborator c=new Collaborator();
	private int choice;
	
	public CollaboratorExeController(Collaborator c) {
		this.c=c;
	}
	
	
	public void SetChoice(int c) {
		this.choice=c;
	}
	
	
	
	@Override
	public void messages() {
		System.out.println("1-Collaborate to Store");
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
		I_ReturnStringChoices r;
		if(this.choice==1) {
			s=new CollaborateController();
			s.messages();
			r=new CollaborateController(this.c);
			r.Get_choice();
			ExecuteUser();
		}
		
		else if(this.choice==2) {
			System.out.println("Successful Logout");
			return;
		}
		
	}

	



}
