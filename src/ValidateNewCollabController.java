import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ValidateNewCollabController implements I_SystemMessages, I_UserInputs ,I_ReturnStringChoices{

	private StoreOwner s=new StoreOwner();
	private String choice;
	
	public  ValidateNewCollabController() {
		this.s=null;
	}
	
	public  ValidateNewCollabController(StoreOwner s) {
		this.s=s;
	}
	
	public void SetChoice(String c){
		this.choice=c;
	}
	
	
	@Override
	public void messages() {
		System.out.println("Enter tne username of the collaborator you want to add: ");
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
			if(CheckValidity()==false) {
				System.out.println("Invalid collaborator username!");
				System.exit(1);
			}
			else {
				I_SystemMessages m=new CollabToStoreController();
				m.messages();
				I_ReturnStringChoices rt=new CollabToStoreController(this.s,this.choice);
				rt.Get_choice();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	public boolean CheckValidity() throws IOException {
		String filename=Database.CollaboratorsUsername;
		ArrayList<String>names=new ArrayList<String>();
		I_ReadFromFiles f=new ReadDataController();
		names=f.readFile(filename);
		for(int i=0; i<names.size(); i++) {
			if(names.get(i).equals(this.choice)) {
				return true;
			}
			else 
				continue;	
		}
		return false;
	}


}
