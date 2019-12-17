import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadPasswordsController implements I_ReadFromFiles {

	@Override
	public ArrayList<String> readFile(String filename) throws IOException {
		File file = new File(filename);
		Scanner obj= new Scanner(file);
		String read;
		ArrayList<String> written = new ArrayList<String>();
		while(obj.hasNextLine()) {
		    read=obj.nextLine();
			written.add(read);
		}
	
		return written;
		
	}
	

}
