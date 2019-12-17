import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteRegData implements I_WriteToFiles{

	@Override
	public void writeData(String data, String filename) throws IOException {
		File f1 = new File(filename);
		FileWriter fileWriter1= new FileWriter(f1,true);
		BufferedWriter bw1 =new BufferedWriter(fileWriter1);
		bw1.newLine();
	    bw1.write(data);
	    bw1.close();
		
	}
	

}
