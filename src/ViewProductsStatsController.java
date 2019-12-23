import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewProductsStatsController implements I_SystemMessages,I_UserInputs,I_ReturnStringChoices{

	private String storename=null;
	private ArrayList<String>Data=new ArrayList<String>();
	private Adminstrator a=new Adminstrator();
	
	public ViewProductsStatsController() {
		this.storename="";
		this.Data=null;
		this.a=null;
	}
	
	public ViewProductsStatsController(Adminstrator a) {
		this.a=a;
		this.Data=null;
		this.storename=null;
	}
	
	public void SetStoreName(String s){
		this.storename=s;
	}
	
	
	@Override
	public void messages() {
		System.out.println("Enter the name of the store you want to get its statistics: ");
		
	}

	
	@Override
	public void getUserInputs() throws IOException {
		Scanner n = new Scanner(System.in);
		SetStoreName(n.next());
	}
	

	@Override
	public String Get_choice() {
		try {
			getUserInputs();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String filename=this.storename+".txt";
		if(CheckExistence(filename)==false) {
			System.out.println("There is no store with this name.");
			System.exit(1);
		}
		else {
			Subject sub=new ProdsStatsSubject();
			UpdateProdsStatsController u=new UpdateProdsStatsController(sub,this.storename);
			try {
				u.Get_ProductStats();
				this.Data=u.getData();
				sendData();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	
	public boolean CheckExistence(String filename) {
		File f=new File(filename);
		if(f.exists()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	public void sendData() {
		this.a.ProdsStats(this.Data);
	}



}
