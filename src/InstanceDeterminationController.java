import java.io.IOException;

public class InstanceDeterminationController implements I_ReturnStringChoices{

	User user=null;
	
	public InstanceDeterminationController(User u) {
		this.user=u;
	}
	
	
	public void identify() {
		if(this.user instanceof Customer) {
			Customer c=new Customer();
			c.Set_data(this.user.getUsername(),this.user.getPassword());
			I_UserExecution ct=new CustomerExeController(c);
			try {
				ct.ExecuteUser();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(this.user instanceof Adminstrator) {
			Adminstrator a=new Adminstrator();
			a.SetData(this.user.getUsername(),this.user.getPassword());
			I_UserExecution ct=new AdminstratorExeController(a);
			try {
				ct.ExecuteUser();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(this.user instanceof StoreOwner) {
			StoreOwner s=new StoreOwner();
			s.SetData(this.user.getUsername(),this.user.getPassword(),StoreOwner.get_type());
			I_UserExecution ct=new StoreOwnerExeController(s);
			try {
				ct.ExecuteUser();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(this.user instanceof Collaborator) {
			Collaborator cb=new Collaborator();
			try {
				cb.Set_data(this.user.getUsername(),this.user.getPassword());
				I_UserExecution ct=new CollaboratorExeController(cb);
				ct.ExecuteUser();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	@Override
	public String Get_choice() {
		identify();
		return null;
}
	
}