import java.io.IOException;
import java.util.ArrayList;

public class OnlineStores implements Stores {

	private String name;
	private String category;
	private ArrayList<Stores>onlineStores=new ArrayList<Stores>();
	private ArrayList<Products>OnlineStoresProducts=new ArrayList<Products>();
	
	
	public OnlineStores() {
		this.name="";
		this.category="";
	}
	
	public OnlineStores(String Name,String Category) {
		this.name=Name;
		this.name=Category;
	}
	
	
	public OnlineStores(String Name) {
		this.name=Name;
	}
	
	public void setStoreInfo(String Name,String Category) {  
		//OnlineStores s=new OnlineStores(Name,Category);
	}
	
	public void setStore_Name(String Name) {
		this.name=Name;
	}
	
	public void setStore_Category(String Category) {
		this.category=Category;
	}
	
	
	public String getStore_Name() {
		return this.name;
	}
	
	
	public String getStore_Category() {
		return this.category;
	}
	
	
	public ArrayList<Stores> getStores() throws IOException {	
		I_ReadStoresFromFiles r=new ReadOnlineStoresController();
		this.onlineStores=r.readStores();
		return this.onlineStores;	
	}
	
	
	public void setStoreProducts() throws IOException {	
		String filename=this.name+".txt";
		I_ReadProdsFromFiles f=new ReadStoreProdsController();
		this.OnlineStoresProducts=f.readProds(filename);
			
	}
	
	public ArrayList<Products> get_StoreProducts() throws IOException{
		setStoreProducts();
		return this.OnlineStoresProducts;
	}
	
	
	@Override
	public void setStore_Data(String Name, String Category,String address) {
		this.name=Name;
		this.category=Category;
	}

	@Override
	public String getStore_Address() {
		return null;
	}

	


}