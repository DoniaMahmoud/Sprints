import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class User extends Database {
	public String username;
	public String password;
	
	
	public void register(String username,String password, int indicator) throws IOException {
		String usernamefile="";
		String passwordfile="";
		Scanner n=new Scanner(System.in);
		if(indicator==1) {
			usernamefile=AdminUsername;
			passwordfile=AdminPassword;
		}
		else if(indicator==2) {
			usernamefile=CustomerUsername;
			passwordfile=CustomerPassword;
		}
		else if(indicator==3) {
			usernamefile=StoreOwnerUsername;
			passwordfile=StoreOwnerPassword;
		}
		else if(indicator==4) {
			usernamefile=OnlineStoreOwnerUsername;
			passwordfile=OnlineStoreOwnerPassword;
		}
		
		if(ValidationController.registerValidate(username, usernamefile)==false) {
			System.out.println("This username is taken. Please try another one");
			String usern= n.next();
			register(usern,password,indicator);
		    return;
		}
		
		else {
			DataController.WriteInUserFiles(username, usernamefile, password, passwordfile, indicator);
			System.out.println("Registered Successfully");
			
		
		}

	
}
	
	
	public void login(String username,String password, int indicator) throws IOException {
		String usernamefile="";
		String passwordfile="";
		Scanner n=new Scanner(System.in);
		if(indicator==1) {
			usernamefile=AdminUsername;
			passwordfile=AdminPassword;
		}
		else if(indicator==2) {
			usernamefile=CustomerUsername;
			passwordfile=CustomerPassword;
		}
		else if(indicator==3) {
			usernamefile=StoreOwnerUsername;
			passwordfile=StoreOwnerPassword;
		}
		else if(indicator==4) {
			usernamefile=OnlineStoreOwnerUsername;
			passwordfile=OnlineStoreOwnerPassword;
		}
	
		if(ValidationController.loginValidate(username, usernamefile,password,passwordfile)==false) {
			username= n.next();
			password=n.next();
			login(username,password,indicator);
			return;
		}
		else{
		return;
		}
		
		
		
	
}
	
}