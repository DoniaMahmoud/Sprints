import java.io.File;
import java.io.IOException;

public abstract class User extends Database {

	protected String username;
	protected String password;
	public abstract void Set_data(String username,String password) throws IOException;
	public abstract String getUsername();
	public abstract String getPassword();
	public void register(String username,String password, String usernamefile, String passwordfile) throws IOException {
		I_WriteToFiles w=new WriteRegData();
		w.writeData(username, usernamefile);
		w.writeData(password, passwordfile);
		if(!usernamefile.contains("Admin")) {
			create_UserPath(username);
		}
	    
	}
	
	
	
	
	
	
	
}
