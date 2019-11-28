import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ValidationController {

	public static boolean registerValidate(String username,String usernamefile) throws IOException {
		File file = new File(usernamefile);
		Scanner obj= new Scanner(file);
		String read;
		ArrayList<String> written = new ArrayList<String>();
		while(obj.hasNextLine()) {
		    read=obj.nextLine();
			written.add(read);
		}
		for(int i=0; i<written.size(); i++) {
			if(username.equals(written.get(i))) {
				return false;
			}
			else {
				continue;
			}
	}
return true;
}
	
	
	
	public static boolean loginValidate(String username,String usernamefile,String password,String passwordfile) throws IOException {
		File file1 = new File(usernamefile);
		Scanner obj1= new Scanner(file1);
		boolean found1 =false;
		boolean found2 =false;
		ArrayList<String> written1= new ArrayList <String>();
		String read1=null;
		while(obj1.hasNextLine()) {
			read1=obj1.nextLine();
			written1.add(read1);
		}
		obj1.close();
		
		File file2 = new File(passwordfile);
		Scanner obj2= new Scanner(file2);
		ArrayList<String> written2= new ArrayList <String>();
		String read2=null;
		while(obj2.hasNextLine()) {
			read2=obj2.nextLine();
			written2.add(read2);
		}
		obj2.close();
		
		
		for(int i=0; i<written1.size(); i++) {
			if(username.equals(written1.get(i))) {
				found1=true;
				break;
			}
			
			
		}
		
		if(found1==true) {
			for(int i=0; i<written2.size(); i++) {
				if(password.equals(written2.get(i))) {
					found2=true;
					System.out.println("Successful login!");
					return true;
				}	
			}
			
			if(found2==false) {
				 System.out.println("Incorrect Password.");
				 System.out.println("Please enter your username and password again: ");
				 return false;
			}
			
		}
		
		else {
			System.out.println("Incorrect Username.");
			System.out.println("Please enter your username and password again: ");			
			return false;
		}
		
		
return true;
		
}
	
	
	
	
	
	
	
}