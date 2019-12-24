import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Customer extends User{
	
	public Customer (){
		this.username="";
		this.password="";
	}
	
	
	public Customer (String username,String password) throws IOException {
		this.username=username;
		this.password=password;
	}
	
	public void Set_data(String username,String password) {
		this.username=username;
		this.password=password;
	}
	
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	
	
	public void BuyProduct(Products p,String address) throws IOException {
		String filename=this.username+".txt";
		I_WriteProdsToFiles w=new WriteProdsToStoresController();
		w.WriteProducts(filename, p);
		I_WriteToFiles f=new WriteRegData();
		f.writeData(address,filename);
	}
	
	public void BuyProductStoreOwner(Products p,String address) throws IOException {
		String filename=this.username+"Purchase.txt";
		I_WriteProdsToFiles w=new WriteProdsToStoresController();
		w.WriteProducts(filename, p);
		I_WriteToFiles f=new WriteRegData();
		f.writeData(address,filename);
	}
	
	public boolean CheckIfStoreOwner() throws IOException {
		ArrayList<String> names = new ArrayList<String>();
		I_ReadFromFiles file = new ReadDataController();
		String filename2=Database.StoreOwnerUsername;
		names=file.readFile(filename2);
		for(int i=0; i<names.size(); i++) {
			if(this.username.equals(names.get(i))) {
				return true;
			}
			
		}
	
		return false;
	}

	 public boolean FirstTimeToBuy() throws IOException {
	    	String filename=this.username+"Purchase.txt";
	    	File file = new File(filename);
	    	if(file.length()==0) {
	    		return true;
	    	}
	    	return false;
	    }

}
