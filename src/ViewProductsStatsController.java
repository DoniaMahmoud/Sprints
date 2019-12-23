import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ViewProductsStatsController implements I_SystemMessages,I_UserInputs,I_ReturnStringChoices{

	private String storename=null;
	private int TotalNoProds=0;
	private int HighestProdAmount=0;
	private String HighestProdName=null;
	private Adminstrator a=new Adminstrator();
	
	
	public ViewProductsStatsController() {
		this.storename="";
	    int TotalNoProds=0;
	    int HighestProdAmount=0;
	    String HighestProdName=null;
		this.a=null;
	}
	
	public ViewProductsStatsController(Adminstrator a) {
		this.a=a;
		int TotalNoProds=0;
	    int HighestProdAmount=0;
	    String HighestProdName=null;
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
			UpdateProdsStatsController u=new UpdateProdsStatsController();
			try {
				u.Get_ProductStats(filename);
				this.TotalNoProds=u.getTotalProducts();
				this.HighestProdAmount=u.getProductAmount();
				this.HighestProdName=u.getProductName();
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
		this.a.ProdsStats(this.TotalNoProds,this.HighestProdName,this.HighestProdAmount);
	}



}
