import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteNewBrandsController implements I_WriteBrandsToFiles{

	@Override
	public void WriteBrands(String filename, Brands b) throws IOException {
		File f2 = new File(filename);
		FileWriter fileWriter2= new FileWriter(f2,true);
		BufferedWriter bw2 =new BufferedWriter(fileWriter2);
		bw2.write(b.getBrandName());
		bw2.newLine();
		bw2.write(b.getBrandCategory());
		bw2.newLine();
		bw2.close();
	}
}
