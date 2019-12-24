import java.io.IOException;

public class StoreOwnerAdapter implements I_Collaborator{

	private StoreOwner s=new StoreOwner();
	
	public StoreOwnerAdapter(StoreOwner s) {
		this.s=s;
	}
	
	@Override
	public void addProducts() throws IOException {
		I_SystemMessages s=new StoreValidationController();
		s.messages();
		I_UserInputs u=new StoreValidationController(this.s);
		u.getUserInputs();
		System.out.println("Product added to your store successfully");
	}

}
