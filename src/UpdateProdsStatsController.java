import java.io.IOException;
import java.util.ArrayList;

public class UpdateProdsStatsController extends Observer {

	private ArrayList<Products>products=new ArrayList<Products>();
	private ArrayList<String>data=new ArrayList<String>();
	private String Storename=null;
	private String ProductName=null;
	private int ProductAmount=0;
	private Subject sub;
	
	
	public UpdateProdsStatsController() {
		this.products=null;
	}
	
	
	public UpdateProdsStatsController(String storeName) {
		this.Storename=storeName;
	}
	
	
	public UpdateProdsStatsController(Subject sub,String storeName) {
		this.sub=sub;
		sub.registerObserver(this);
		this.Storename=storeName;
	}
	
	
	
	@Override
	public void update() throws IOException {
		String filename=this.Storename+".txt";
		I_ReadProdsFromFiles f=new ReadStoreProdsController();
		this.products=f.readProds(filename);
		int index=0;
		for(int i=0; i<this.products.size(); i++) {
			if(this.products.get(i).get_amount()>this.ProductAmount) {
				this.ProductAmount=products.get(i).get_amount();
				index=i;
			}
			else {
				continue;
			}
		}
		this.ProductName=this.products.get(index).get_name();
		SaveData();
	}
	
	
	
	public void SaveData() throws IOException {
		String filename=this.Storename+"ProdsStats.txt";
		String TotalProds=String.valueOf(this.products.size());
		String Amount=String.valueOf(this.ProductAmount);
		this.data.add(TotalProds);
		this.data.add(this.ProductName);
		this.data.add(Amount);
		I_WriteArrayToFiles f=new OverWriteDataController();
		f.writeData(this.data,filename);
	}
	
	
	public void Get_ProductStats() throws IOException {
		String filename=this.Storename+"ProdsStats.txt";
		 I_ReadFromFiles files= new ReadDataController();
		  this.data=files.readFile(filename);
	}
	
	
	public ArrayList<String> getData() {
		return this.data;
	}
	

	
}

