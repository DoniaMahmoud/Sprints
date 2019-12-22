import java.io.IOException;
import java.util.ArrayList;

public class ValidationController implements I_EntryValidation{

	@Override
	public boolean registerValidate(String username, String usernamefile) throws IOException {
		I_ReadFromFiles r=new ReadUsernamesController();
		ArrayList <String> written= new ArrayList<String>();
		written=r.readFile(usernamefile);
		for(int i=0; i<written.size(); i++) {
			if(username.equals(written.get(i))) {
				System.out.println("Username is taken.");
				return false;
			}
			else {
				continue;
			}
		}
		System.out.println("Successful Registeration.");
		return true;
	
	}

	@Override
	public boolean loginValidate(String username, String usernamefile, String password, String passwordfile) throws IOException {
		boolean found1 =false;
		boolean found2 =false;
		I_ReadFromFiles r=new ReadUsernamesController();
		ArrayList <String> written1= new ArrayList<String>();
		written1=r.readFile(usernamefile);
		r=new ReadPasswordsController();
		ArrayList <String> written2= new ArrayList<String>();
		written2=r.readFile(passwordfile);
		int index=0;
		for(int i=0; i<written1.size(); i++) {
			if(username.equals(written1.get(i))) {
				index=i;
				found1=true;
				break;
			}
		}
		if(found1==true) {
			for(int i=0; i<written2.size(); i++) {
				if(password.equals(written2.get(i))) {
					if(index==i) {
						found2=true;
						System.out.println("Successful login!");
						return true;
					}
				}	
			}
			if(found2==false) {
				 System.out.println("Incorrect Password.");
				 return false;
			}	
		}
		else {
			System.out.println("Incorrect Username.");		
			return false;
		}
		
return true;	
	}

}
