import java.io.IOException;
import java.util.ArrayList;

public class OnlineStore extends Store {

	private ArrayList<Products>OnlineStoreProducts=new ArrayList<Products>();
	
	public OnlineStore() {
		this.name="";
		this.type="";
	}
	
	public OnlineStore(String name) {
		this.name=name;
	}
	
	public OnlineStore(String Name,String type) {
		this.name=Name;
		this.type=type;
		
	}
	
	public void setStoreInfo(String Name,String type) {  
		OnlineStore s=new OnlineStore(Name,type);
	
	}
	
	public void setStore_Name(String Name) {
		this.name=Name;
	}
	
	public void setStore_Type(String Type) {
		this.type=Type;
	}
	
	
	public String getStore_Name() {
		return this.name;
	}
	
	
	public String getStore_Type() {
		return this.type;
	}
	
	public void setOnlineStoreProducts(ArrayList<Products> p) throws IOException {	
		this.OnlineStoreProducts=p;
			
	}
	
	public ArrayList<Products> get_OnlineStoreProducts(){
		return this.OnlineStoreProducts;
	}




}