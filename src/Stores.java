import java.io.IOException;
import java.util.ArrayList;

public interface Stores {

	public  void setStore_Name(String Name);
	public  void setStore_Category(String category);
	public  void setStore_Data(String Name,String category,String address);
	public  String getStore_Name();
	public  String getStore_Category();
	public String getStore_Address();
	public ArrayList<Stores> getStores() throws IOException;
	public void setStoreProducts() throws IOException;
	public ArrayList<Products> get_StoreProducts() throws IOException;
}