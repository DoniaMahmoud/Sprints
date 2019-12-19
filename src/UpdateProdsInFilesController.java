import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UpdateProdsInFilesController implements I_UpdateStoreProducts{

	@Override
	public void UpdateFile(String filename, ArrayList<Products> p) throws IOException {
		File f2 = new File(filename);
		FileWriter fileWriter2= new FileWriter(f2,false);
		BufferedWriter bw2 =new BufferedWriter(fileWriter2);
		for(int i=0; i<p.size(); i++) {
			 bw2.write(p.get(i).get_name());
			 bw2.newLine();
			 bw2.write(String.valueOf(p.get(i).get_SerialNo()));
			 bw2.newLine();
			 bw2.write(p.get(i).get_category());
			 bw2.newLine();
			 bw2.write(p.get(i).get_type());
			 bw2.newLine();
			 bw2.write(p.get(i).get_Brand().getBrandName());
			 bw2.newLine();
			 bw2.write(p.get(i).get_Brand().getBrandCategory());
			 bw2.newLine();
			 bw2.write(String.valueOf(p.get(i).get_price()));
			 bw2.newLine();
			 bw2.write(String.valueOf(p.get(i).get_amount()));
			 bw2.newLine();			
		}
		 bw2.close();
		
	}

	
}
