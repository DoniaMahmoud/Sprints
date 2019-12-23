import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UpdateUserStatsController {
	
	private ArrayList<String>StoreOwners=new ArrayList<String>();
	private ArrayList<String>OnlineStoreOwners=new ArrayList<String>();
	private ArrayList<String>Customers=new ArrayList<String>();
	  
	
	public UpdateUserStatsController() {
		this.StoreOwners=null;
		this.OnlineStoreOwners=null;
		this.Customers=null;
	}
	
	
	
	public void UpdateUserStats() throws IOException {
      I_ReadFromFiles files= new ReadUsernamesController();	
	  String filename1 = Database.StoreOwnerUsername;
	  this.StoreOwners=files.readFile(filename1);
	  String filename2 = Database.OnlineStoreOwnerUsername;
	  this. OnlineStoreOwners=files.readFile(filename2);
	  String filename3 = Database.CustomerUsername;
	  this.Customers=files.readFile(filename3);	  
	  
    }
	
	public int getTotalCustomers() {
		return this.Customers.size();
	}
	
	
	public int getTotalStoreOwners() {
		return this.StoreOwners.size();
	}
	
	public int getTotalOnlineStoreOwners() {
		return this.OnlineStoreOwners.size();
	}
	
	
	public int getTotalUsers() {
		int total = getTotalCustomers() + getTotalStoreOwners() + getTotalOnlineStoreOwners();
		return total;
	}
	
	
	
}