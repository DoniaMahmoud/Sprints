import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadOnlineStoresController implements I_ReadStoresFromFiles {

	private String OnlineStoreOwnerUsername = "OnlineStoreOwnerUsername.txt";
	private ArrayList<Stores> SystemOnlineStores=new ArrayList<Stores>();
	private ArrayList<String> OnlineOwners=new ArrayList<String>();
	
	public ArrayList <String> getStoreOwners() throws IOException{
		ArrayList<String>filenames=new ArrayList<String>();
		I_ReadFromFiles r=new ReadDataController();
		this.OnlineOwners=r.readFile(OnlineStoreOwnerUsername);
		for(int i=0; i<this.OnlineOwners.size(); i++) {
			filenames.add(this.OnlineOwners.get(i)+".txt");
		}
		return filenames;
	}
	
	public ArrayList<Stores> getstores(File f) throws IOException{
		String name,category;
		ArrayList<Stores>stores=new ArrayList<Stores>();
		Scanner obj= new Scanner(f);
		int lines=0;
		while(obj.hasNextLine()) {
			lines++;
			obj.nextLine();
		}
		int StoresNo=lines/2;
		Scanner obj2= new Scanner(f);
		for(int i=0; i<StoresNo; i++) {
			name=obj2.nextLine();
			category=obj2.nextLine();
			Stores s=new OnlineStores();
			s.setStore_Data(name, category, null);
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
			if(f2.length()!=0) {
				stores=getstores(f2);
				for(int j=0; j<stores.size(); j++) {
					this.SystemOnlineStores.add(stores.get(j));
				}
			}
			else 
				continue;
		}
		
		return this.SystemOnlineStores;
	}
	
	public ArrayList<String> GetOnlineOwners(){
		return this.OnlineOwners;
	}

}
