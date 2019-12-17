
public class FileConditionsController {

	private static String usernamefile;
	private  static String passwordfile;

	
	public static String UsernameFileCond (int c) {
		if(c==1) {
			
			usernamefile=Database.CustomerUsername;
			
		}
		else if(c==2) {
			usernamefile=Database.AdminUsername;
			
		}
		else if(c==3) {
			if(StoreOwner.get_type().equals("onsite")) {
				usernamefile=Database.StoreOwnerUsername;
			}
			else if(StoreOwner.get_type().equals("online")) {
				usernamefile=Database.OnlineStoreOwnerUsername;

			}
		}
		return usernamefile;
	}
	
	
	
	public static String PasswordFileCond (int c) {
		if(c==1) {
			
			passwordfile=Database.CustomerPassword;
		}
		else if(c==2) {
			passwordfile=Database.AdminPassword;
		}
		else if(c==3) {
			if(StoreOwner.get_type().equals("onsite")) {
				passwordfile=Database.StoreOwnerPassword;
			}
			else if(StoreOwner.get_type().equals("online")) {
				passwordfile=Database.OnlineStoreOwnerPassword;
			}
		}
		return passwordfile;

	}
	
	
	
}
