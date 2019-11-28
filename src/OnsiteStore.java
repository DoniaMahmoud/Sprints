import java.io.IOException;
import java.util.ArrayList;

public class OnsiteStore extends Store{
	private String address;
	private ArrayList<Products>OnsiteStoreProducts=new ArrayList<Products>();
	
	
	public OnsiteStore() {
		this.name="";
		this.type="";
		this.address="";
	}
	
	
	public OnsiteStore(String name) {
		this.name=name;
	}
	
	public OnsiteStore(String Name,String type,String address) {
		this.name=Name;
		this.type=type;
		this.address=address;
	}
	
	
	
	public void setStoreInfo(String Name,String type,String address) {   
		OnsiteStore s=new OnsiteStore(Name,type,address);
	
	
	}
	
	public void setStore_Name(String Name) {
		this.name=Name;
	}
	
	public void setStore_Type(String Type) {
		this.type=Type;
	}
	
	public void setStore_Address(String Address) {
		this.address=Address;
	}
	
	
	public String getStore_Name() {
		return this.name;
	}
	
	
	public String getStore_Type() {
		return this.type;
	}
	
	
	public String getStore_Address() {
		return this.address;
	}

	
	public void setOnsiteStoreProducts(ArrayList<Products> p) throws IOException {	
		OnsiteStoreProducts=p;
			
	}
	
	public ArrayList<Products> get_OnsiteStoreProducts(){
		return OnsiteStoreProducts;
	}



}