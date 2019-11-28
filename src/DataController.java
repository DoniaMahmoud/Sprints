import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public interface DataController {

	public static void WriteInUserFiles(String username,String usernamefile,String password,String passwordfile, int indicator) throws IOException {
		Database.WriteRegData(username, usernamefile, password, passwordfile, indicator);
	}
	
	
	
	
	
	
}