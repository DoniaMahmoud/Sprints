import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UpdateUserStatsController extends Observer{
	
	private ArrayList<String>StoreOwners=new ArrayList<String>();
	private ArrayList<String>OnlineStoreOwners=new ArrayList<String>();
	private ArrayList<String>Customers=new ArrayList<String>();
	private ArrayList<String>Collaborators=new ArrayList<String>();
	private ArrayList<String> data=new ArrayList<String>();
	private Subject sub;

	
	public UpdateUserStatsController() {
		this.StoreOwners=null;
		this.OnlineStoreOwners=null;
		this.Customers=null;
		this.Collaborators=null;
	}
	
	public UpdateUserStatsController(Subject sub) {
		this.sub=sub;
		sub.registerObserver(this);
	}
	
	
	
	@Override
	public void update() throws IOException {
		 I_ReadFromFiles files= new ReadDataController();	
		  String filename1 = Database.StoreOwnerUsername;
		  this.StoreOwners=files.readFile(filename1);
		  String filename2 = Database.OnlineStoreOwnerUsername;
		  this. OnlineStoreOwners=files.readFile(filename2);
		  String filename3 = Database.CustomerUsername;
		  this.Customers=files.readFile(filename3);
		  String filename4 = Database.CollaboratorsUsername;
		  this.Collaborators=files.readFile(filename4);
		  SaveData();
	}
	
	
	public void SaveData() throws IOException {
		String TotalCustomers=String.valueOf( this.Customers.size());
		String TotalOnlineStoreOwners=String.valueOf( this.OnlineStoreOwners.size());
		String TotalStoreOwners=String.valueOf( this.StoreOwners.size());
		String TotalCollaborators=String.valueOf( this.Collaborators.size());
		int TotalUsers=this.Customers.size()+this.OnlineStoreOwners.size()+this.StoreOwners.size()+this.Collaborators.size();
		String TotalUSers=String.valueOf(TotalUsers);
		this.data.add(TotalCustomers);
		this.data.add(TotalOnlineStoreOwners);
		this.data.add(TotalStoreOwners);
		this.data.add(TotalCollaborators);
		this.data.add(TotalUSers);
		I_WriteArrayToFiles f=new OverWriteDataController();
		f.writeData(this.data,Database.UserStats);
	}

	
	
	public void GetUserStats() throws IOException {
      I_ReadFromFiles files= new ReadDataController();
      String filename1=Database.UserStats;
	  this.data=files.readFile(filename1);	
    }
	
	public ArrayList<String> getData() {
		return this.data;
	}





	
	
	
}