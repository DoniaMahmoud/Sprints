import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CollaborateController implements I_SystemMessages, I_UserInputs,I_ReturnStringChoices{

	private Collaborator c=new Collaborator();
	private String choice;
	
	
	
	public CollaborateController(Collaborator c) {
		this.c=c;
	}
	
	public CollaborateController() {
		this.c=null;
	}
	
	public void SetChoice(String c) {
		this.choice=c;
	}
	
	
	@Override
	public void messages() {
		System.out.println("Enter the store you want to collaborate to: ");
	}
	
	
	@Override
	public void getUserInputs() throws IOException {
		Scanner s=new Scanner(System.in);
		SetChoice(s.next());
	}
	
	
	@Override
	public String Get_choice() {
		try {
			getUserInputs();
			CheckStore();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	public void CheckStore() throws IOException {
		ReadOnlineStoresController Onr=new ReadOnlineStoresController();
		ReadOnsiteStoresController Osr=new ReadOnsiteStoresController();
		ArrayList<Stores> onStores=new ArrayList<Stores>();
		ArrayList<Stores> osStores=new ArrayList<Stores>();
		ArrayList<String> onlineOwners=new ArrayList<String>();
		ArrayList<String> onsiteOwners=new ArrayList<String>();
		onStores=Onr.readStores();
		osStores=Osr.readStores();
		onlineOwners=Onr.GetOnlineOwners();
		onsiteOwners=Osr.GetOnsiteOwners();
		int index;
		String type;
		String Ownername;
		index=SearchStores(osStores);
		if(index!=-1) {
			type="onsite";
			Ownername=onsiteOwners.get(index);
			if(CheckCollaborationValidity()==false) {
				System.out.println("You can't collaborate to this store!");
				System.exit(1);
			}
			else {
				AdapteProcess(Ownername,type);
			}
		}
		else {
			index=SearchStores(onStores);
			if(index!=-1) {
				type="online";
				Ownername=onlineOwners.get(index);
				if(CheckCollaborationValidity()==false) {
					System.out.println("You can't collaborate to this store!");
					System.exit(1);
				}
				else {
					AdapteProcess(Ownername,type);
				}
			}
			else {
				System.out.println("No store found with this name!");
				System.exit(1);
			}
		}
		
	}
	
	
	public int SearchStores(ArrayList<Stores> stores) {
		int index;
		for(int i=0; i<stores.size(); i++) {
			if(this.choice.equals(stores.get(i).getStore_Name())) {
				index=i;
				return index;
			}
			else 
				continue;
		}
		return -1;
	}
	
	
	public boolean CheckCollaborationValidity() throws IOException {
		String filename=this.choice+"Collaborators.txt";
		ArrayList<String>names=new ArrayList<String>();
		I_ReadFromFiles f= new ReadDataController();
		names=f.readFile(filename);
		for(int i=0; i<names.size(); i++) {
			if(this.c.getUsername().equals(names.get(i))) {
				return true;
			}
			else 
				continue;
		}
		return false;
	}
	
	public void AdapteProcess(String name, String type) throws IOException {
		StoreOwner s=new StoreOwner();
		s.setUsername(name);
		s.Settype(type);
		I_Collaborator adpt=new StoreOwnerAdapter(s);
		adpt.addProducts();
	}
	
}
