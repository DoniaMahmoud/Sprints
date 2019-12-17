import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteProdsToStoresController implements I_WriteProdsToFiles{

	@Override
	public void WriteProducts(String filename, Products p) throws IOException {
		 File f2 = new File(filename);
		 FileWriter fileWriter2= new FileWriter(f2,true);
		 BufferedWriter bw2 =new BufferedWriter(fileWriter2);
		 bw2.write(p.get_name());
		 bw2.newLine();
		 bw2.write(String.valueOf(p.get_SerialNo()));
		 bw2.newLine();
		 bw2.write(p.get_category());
		 bw2.newLine();
		 bw2.write(p.get_type());
		 bw2.newLine();
		 bw2.write(p.get_Brand().getBrandName());
		 bw2.newLine();
		 bw2.write(p.get_Brand().getBrandCategory());
		 bw2.newLine();
		 bw2.write(String.valueOf(p.get_price()));
		 bw2.newLine();
		 bw2.write(String.valueOf(p.get_amount()));
		 bw2.newLine();			
		 bw2.close();
		 
	}

}
