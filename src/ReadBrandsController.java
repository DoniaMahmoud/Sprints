import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadBrandsController implements I_ReadBrandsFromFiles {
	
private ArrayList<Brands>SystemBrands=new ArrayList<Brands>();

	
	@Override
	public ArrayList<Brands> readBrands(String filename) throws IOException {
		File file = new File(filename);
		Scanner obj= new Scanner(file);
	    String name1,category1;
		int lines=0;
		while(obj.hasNextLine()) {
			lines++;
			obj.nextLine();
		}
		int BrandsNo=lines/2;
		Scanner obj2= new Scanner(file);
	
		for(int i=0; i<BrandsNo; i++) {
			name1=obj2.nextLine();
			category1=obj2.nextLine();
			Brands b=new Brands();
		    b.set(name1,category1);
		    this.SystemBrands.add(b);
		    
		}
		obj.close();
		obj2.close();
		return this.SystemBrands;
	}


}
