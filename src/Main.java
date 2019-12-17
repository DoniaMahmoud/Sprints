import java.io.IOException;
import java.util.Scanner;


public class Main {
	public static void main(String arg[]) throws IOException {
		String username=null;
		String password=null;
		String usernamefile=null;
		String passwordfile=null;
		I_ReturnStringChoices st=null;
		UserAccountFactory fac= new UserAccountFactory();
		I_identifyUser u=new identifyUserController(fac);
		I_SystemMessages s=new RegOrLogController();
		s.messages();
		I_ReturnIntChoices r=new RegOrLogController();
		int choice=r.get_choice();
		if(choice==1) {
			s=new IdentifyRegMessagesController();
			s.messages();
			r=new IdentifyRegMessagesController();
			int choice2=r.get_choice();
			User user=null;
			user=u.createUserAccount(choice2);
			s=new Usernames();
			s.messages();
			st=new Usernames();
			username=st.Get_choice();
			s=new Passwords();
			s.messages();
			st=new Passwords();
			password=st.Get_choice();
			user.Set_data(username, password);
			usernamefile=FileConditionsController.UsernameFileCond(choice2);
			passwordfile=FileConditionsController.PasswordFileCond(choice2);
			I_EntryValidation v=new ValidationController();
			boolean f=v.registerValidate(username, usernamefile);
			while(f==false) {
				s=new Usernames();
				s.messages();
				st=new Usernames();
				username=st.Get_choice();
				s=new Passwords();
				s.messages();
				st=new Passwords();
				password=st.Get_choice();
				user.Set_data(username, password);
				f=v.registerValidate(username, usernamefile);
			}
			user.register(username, password, usernamefile, passwordfile);
			
			
			
		}
		else {
			s=new IdentifyLoginMessagesController();
			s.messages();
			r=new IdentifyLoginMessagesController();
			int choice2=r.get_choice();
			User user=null;
			user=u.createUserAccount(choice2);
			s=new Usernames();
			s.messages();
			st=new Usernames();
			username=st.Get_choice();
			s=new Passwords();
			s.messages();
			st=new Passwords();
			password=st.Get_choice();
			user.Set_data(username, password);
			usernamefile=FileConditionsController.UsernameFileCond(choice2);
			passwordfile=FileConditionsController.PasswordFileCond(choice2);
			I_EntryValidation v=new ValidationController();
			boolean f=v.loginValidate(username, usernamefile, password, passwordfile);
			while(f==false) {
				s=new Usernames();
				s.messages();
				st=new Usernames();
				username=st.Get_choice();
				s=new Passwords();
				s.messages();
				st=new Passwords();
				password=st.Get_choice();
				user.Set_data(username, password);usernamefile=FileConditionsController.UsernameFileCond(choice2);
				passwordfile=FileConditionsController.PasswordFileCond(choice2);
				f=v.loginValidate(username, usernamefile, password, passwordfile);
			}
			//System.out.println(user instanceof Customer);
			
			//Customer c=new Customer();
			//c.Set_data(usernamefile, passwordfile)=user.Set_data(usernamefile, passwordfile);
		}
	
		

		
		
	
		
	}
	

}
