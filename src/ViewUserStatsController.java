import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewUserStatsController implements I_ReturnIntChoices{

	private Adminstrator a=new Adminstrator();
	private ArrayList<String>Data=new ArrayList<String>();
	
	public ViewUserStatsController() {
		this.Data=null;
		this.a=null;
	}

	public ViewUserStatsController(Adminstrator a) {
		this.a=a;
		this.Data=null;
	}
	
	
	@Override
	public int get_choice() {
		UpdateUserStatsController user= new UpdateUserStatsController();
		try {
			user.GetUserStats();
			this.Data=user.getData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SendUserStats();
		return 0;
	}
	
	private void SendUserStats() {  
		this.a.UserStats(this.Data);
		}


}
