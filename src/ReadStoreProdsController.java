import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadStoreProdsController implements I_ReadProdsFromFiles {

	
	private ArrayList<Products>StoreProds=new ArrayList<Products>();

	public int getLines(String filename) throws IOException {
		File file = new File(filename);
		Scanner obj= new Scanner(file);
		int lines=0;
		while(obj.hasNextLine()) {
			lines++;
			obj.nextLine();
		}
		int ProdsNo=lines/8;
		obj.close();
		return ProdsNo;
	}
	
	@Override
	public ArrayList<Products> readProds(String filename) throws IOException {
		int ProdsNo=getLines(filename);
		File file = new File(filename);
		Scanner obj2= new Scanner(file);
		Brands b=new Brands();
		String name1,serial,category1,type1,price1,amount;
		for(int i=0; i<ProdsNo; i++) {
			name1=obj2.nextLine();
			serial=obj2.nextLine();
			category1=obj2.nextLine();
			type1=obj2.nextLine();
			b.setBrandName(obj2.nextLine());
			b.setBrandCategory(obj2.nextLine());
			price1=obj2.nextLine();
			amount=obj2.nextLine();
			Products p=new Products(name1,Integer.parseInt(serial),category1,type1,b,Integer.parseInt(price1),Integer.parseInt(amount));
		    this.StoreProds.add(p); 
		}
		obj2.close();
		return this.StoreProds;
		
	}

	
}
