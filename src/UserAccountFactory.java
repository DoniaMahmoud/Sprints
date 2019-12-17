public class UserAccountFactory {

	public User create_user(int c) {
		User user=null;
		if(c==1) {
			user=new Customer();
		}
		else if(c==2) {
			user=new Adminstrator();
		}
		
		else if(c==3) {
			user=new StoreOwner();
		}
		
		return user;
	}
	
}
