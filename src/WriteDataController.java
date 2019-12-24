import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteDataController implements I_WriteArrayToFiles {

	@Override
	public void writeData(ArrayList<String> data, String filename) throws IOException {
		File f1 = new File(filename);
		FileWriter fileWriter1= new FileWriter(f1,false);
		BufferedWriter bw1 =new BufferedWriter(fileWriter1);
		for(int i=0; i<data.size(); i++) {
		    bw1.write(data.get(i));
		    bw1.newLine();
		}
		 bw1.close();
	}

	
}
