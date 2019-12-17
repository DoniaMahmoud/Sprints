
public class identifyUserController implements I_identifyUser  {
	UserAccountFactory factory;
	
	public identifyUserController() {
		this.factory=null;
	}
	
	public identifyUserController(UserAccountFactory factory) {
		this.factory=factory;
	}

	@Override
	public User createUserAccount(int c) {
		User user;
		user=factory.create_user(c);
		return user;
		
	}

}
