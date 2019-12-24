import java.io.IOException;
import java.util.Scanner;

public class CollabToStoreController implements  I_SystemMessages, I_UserInputs ,I_ReturnStringChoices{

	private StoreOwner s=new StoreOwner();
	private String CollabName;
	private String choice;
	
	public CollabToStoreController(StoreOwner s,String name) {
		this.s=s;
		this.CollabName=name;
	}
	
	
	public CollabToStoreController() {
		this.s=null;
	}
	
	
	public void SetChoice(String c){
		this.choice=c;
	}
	
	
	@Override
	public void messages() {
		System.out.println("Enter the storename you want to add this collaborator to: ");
		
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
			if(Database.searchstores(this.s, this.choice)){
				Database.create_StoreCollabPath(this.choice);
				this.s.AddCollaborator(this.choice,this.CollabName);
			}
			else {
				System.out.println("You don't have a store with this name");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}



}
