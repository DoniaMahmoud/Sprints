import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadSystemProdsController implements I_ReadProdsFromFiles{
	
	private ArrayList<Products>SystemProds=new ArrayList<Products>();

	public int getLines(String filename) throws IOException {
		File file = new File(filename);
		Scanner obj= new Scanner(file);
		int lines=0;
		while(obj.hasNextLine()) {
			lines++;
			obj.nextLine();
		}
		int ProdsNo=lines/5;
		obj.close();
		return ProdsNo;
	}
	
	@Override
	public ArrayList<Products> readProds(String filename) throws IOException {
		int ProdsNo=getLines(filename);
		File file = new File(filename);
		Scanner obj2= new Scanner(file);
		String name1,serial,category1,type1,price1;
		for(int i=0; i<ProdsNo; i++) {
			name1=obj2.nextLine();
			serial=obj2.nextLine();
			category1=obj2.nextLine();
			type1=obj2.nextLine();
			price1=obj2.nextLine();
			Products p=new Products();
		    p.set(name1,category1,type1,Integer.parseInt(price1));
		    p.set_serial(Integer.parseInt(serial));
		    this.SystemProds.add(p);
		    
		}
		obj2.close();
		return this.SystemProds;
	}

}
