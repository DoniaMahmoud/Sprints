import java.io.IOException;
import java.util.ArrayList;

public class OnsiteStores implements Stores{
	private String address;
	private String name;
	private String category;
	private ArrayList<Stores>onsiteStores=new ArrayList<Stores>();
	private ArrayList<Products>OnsiteStoreProducts=new ArrayList<Products>();
	
	
	public OnsiteStores() {
		this.name="";
		this.name="";
		this.address="";
	}
	
	public OnsiteStores(String Name,String Category,String address) {
		this.name=Name;
		this.name=Category;
		this.address=address;
	}
	
	
	public OnsiteStores(String name) {
		this.name=name;
	}
		
	public void setStoreInfo(String Name,String Category,String address) {   
		//OnsiteStore s=new OnsiteStore(Name,Category,address);
	}
	
	public void setStore_Name(String Name) {
		this.name=Name;
	}
	
	public void setStore_Category(String Category) {
		this.category=Category;
	}
	
	public void setStore_Address(String Address) {
		this.address=Address;
	}
	
	
	public String getStore_Name() {
		return this.name;
	}
	
	
	public String getStore_Category() {
		return this.category;
	}
	
	
	public String getStore_Address() {
		return this.address;
	}

	
	public ArrayList<Stores> getStores() throws IOException{
		I_ReadStoresFromFiles r=new ReadOnsiteStoresController();
		this.onsiteStores=r.readStores();
		return this.onsiteStores;	
	}
	
	public void setStoreProducts() throws IOException {	
		String filename=this.name+".txt";
		I_ReadProdsFromFiles f=new ReadStoreProdsController();
		this.OnsiteStoreProducts=f.readProds(filename);
	}
	
	public ArrayList<Products> get_StoreProducts() throws IOException{
		setStoreProducts();
		return this.OnsiteStoreProducts;
	}



	@Override
	public void setStore_Data(String Name, String Category,String address) {
		this.name=Name;
		this.name=Category;
		this.address=address;
	}




	



}