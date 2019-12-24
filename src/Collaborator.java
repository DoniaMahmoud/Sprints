import java.io.IOException;

public class Collaborator extends User implements I_Collaborator{

	
	public  Collaborator (){
		this.username="";
		this.password="";
	}
	
	
	public  Collaborator (String username,String password) {
		this.username=username;
		this.password=password;
	}
	
	
	@Override
	public void Set_data(String username, String password) throws IOException {
		this.username=username;
		this.password=password;
		
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public String getPassword() {
		return this.password;
	}


	@Override
	public void addProducts() {};

}
