import java.io.IOException;
import java.util.Scanner;

public class AdminstratorExeController implements I_UserExecution, I_SystemMessages, I_UserInputs{

	private Adminstrator a=new Adminstrator();
	private int choice;
	
	
	public AdminstratorExeController(Adminstrator a) {
		this.a=a;
	}
	
	
	public void SetChoice(int c) {
		this.choice=c;
	}
	
	
	@Override
	public void messages() {
		System.out.println("1-Add Products: ");
		System.out.println("2-Add Brands ");
		System.out.println("3-View Users' Statistics");
		System.out.println("4-View Products' Statistics");
		System.out.println("5-Logout ");
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
		I_ReturnIntChoices c;
		I_ReturnStringChoices st;
		if(this.choice==1) {
			s=new NewProductController();
			s.messages();
			u=new NewProductController(this.a);
			u.getUserInputs();
			System.out.println("Product added Successfully!");
			ExecuteUser();
		}
		else if(this.choice==2) {
			s=new NewBrandController();
			s.messages();
			u=new NewBrandController(this.a);
			u.getUserInputs();
			System.out.println("Brand added Successfully!");
			ExecuteUser();
		}
		
		else if(this.choice==3) {
			c=new ViewUserStatsController(this.a);
			c.get_choice();
			ExecuteUser();
		}
		
		else if(this.choice==4) {
			s=new ViewProductsStatsController();
			s.messages();
			st=new ViewProductsStatsController(this.a);
			st.Get_choice();
			ExecuteUser();
		}
		
		else if(this.choice==5) {
			System.out.println("Successful Logout");
			return;
		}
		
	}


	


	
}
