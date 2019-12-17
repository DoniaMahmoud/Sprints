import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteOnsiteStores implements I_WriteStores{

	@Override
	public void writeStores(Stores s, String filename) throws IOException {
		File f2 = new File(filename);
		FileWriter fileWriter2= new FileWriter(f2,true);
		BufferedWriter bw2 =new BufferedWriter(fileWriter2);
		bw2.write(s.getStore_Name());
		bw2.newLine();
		bw2.write(s.getStore_Category());
		bw2.newLine();
		bw2.write(s.getStore_Address());
		bw2.newLine();
	    bw2.close();	
	}
}
