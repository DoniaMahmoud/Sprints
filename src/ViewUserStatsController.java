import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewUserStatsController implements I_ReturnIntChoices{

	private Adminstrator a=new Adminstrator();
	private int totalCustomers=0;
	private int totalOnlineStoreOwners=0;
	private int totalStoreOwners=0;
	private int totalUsers=0;
	
	public ViewUserStatsController() {
		this.totalCustomers=0;
		this.totalOnlineStoreOwners=0;
		this.totalStoreOwners=0;
		this.totalUsers=0;
	}

	public ViewUserStatsController(Adminstrator a) {
		this.a=a;
	}

	public ViewUserStatsController(int totalCustomers, int totalOnlineStoreOwners, int totalStoreOwners, int totalUsers) {
		this.totalCustomers=totalCustomers;
		this.totalOnlineStoreOwners=totalOnlineStoreOwners;
		this.totalStoreOwners=totalStoreOwners;
		this.totalUsers=totalUsers;
	

	}	
	
	@Override
	public int get_choice() {
		UpdateUserStatsController user= new UpdateUserStatsController();
		try {
			user.UpdateUserStats();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.totalCustomers=user.getTotalCustomers();
		this.totalStoreOwners=user.getTotalStoreOwners();
		this.totalOnlineStoreOwners=user.getTotalOnlineStoreOwners();
		this.totalUsers=user.getTotalUsers();
		SendUserStats();
		return 0;
	}
	
	private void SendUserStats() {  
		this.a.UserStats(this.totalCustomers, this.totalOnlineStoreOwners, this.totalStoreOwners, this.totalUsers);
		}


}
