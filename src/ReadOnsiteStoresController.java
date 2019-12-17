import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadOnsiteStoresController implements I_ReadStoresFromFiles {

	private String StoreOwnerUsername = "StoreOwnerUsername.txt";
	private ArrayList<Stores> SystemOnsiteStores=new ArrayList<Stores>();
	
	
	public ArrayList <String> getStoreOwners() throws IOException{
		ArrayList<String>owners=new ArrayList<String>();
		ArrayList<String>filenames=new ArrayList<String>();
		I_ReadFromFiles r=new ReadUsernamesController();
		owners=r.readFile(StoreOwnerUsername);
		for(int i=0; i<owners.size(); i++) {
			filenames.add(owners.get(i)+".txt");
		}
		return filenames;
	}
	
	
	
	public ArrayList<Stores> getstores(File f) throws IOException{
		String name,category,address;
		ArrayList<Stores>stores=new ArrayList<Stores>();
		Scanner obj= new Scanner(f);
		int lines=0;
		while(obj.hasNextLine()) {
			lines++;
			obj.nextLine();
		}
		int StoresNo=lines/3;
		Scanner obj2= new Scanner(f);
		for(int i=0; i<StoresNo; i++) {
			name=obj2.nextLine();
			category=obj2.nextLine();
			address=obj2.nextLine();
			Stores s=new OnsiteStores();
			s.setStore_Data(name, category, address);
		    stores.add(s);
		    
		}
		return stores;
	}
	
	
	@Override
	public ArrayList<Stores> readStores() throws IOException {
		ArrayList<String>filenames=new ArrayList<String>();
		ArrayList<Stores>stores=new ArrayList<Stores>();
		filenames=getStoreOwners();
		for(int i=0; i<filenames.size(); i++) {
			File f2=new File(filenames.get(i));
			while(f2.length()!=0) {
				stores=getstores(f2);
				for(int j=0; j<stores.size(); j++) {
					this.SystemOnsiteStores.add(stores.get(j));
				}
			}
		}
		
		return this.SystemOnsiteStores;
	}

}
