import java.io.IOException;
import java.util.ArrayList;

public class UpdateSoldOutStatsController extends Observer{

	private ArrayList<String>ProductNames=new ArrayList<String>();
	private Subject sub;
	private String StoreName;
	
	public UpdateSoldOutStatsController(String Storename) {
		this.StoreName=Storename;
	}
	
	public UpdateSoldOutStatsController(String Storename,Subject sub) {
		this.sub=sub;
		sub.registerObserver(this);
		this.StoreName=Storename;
	}
	
	
	
	@Override
	public void update() throws IOException {
		 String filename=this.StoreName+".txt";
		 ArrayList <Products> products=new ArrayList<Products>();
		 I_ReadProdsFromFiles f= new ReadStoreProdsController();
		 products=f.readProds(filename);
		 for(int i=0; i<products.size(); i++) {
				if(products.get(i).get_amount()==0) {
					this.ProductNames.add(products.get(i).get_name());
					continue;
				}
			}
		 SaveData();
	}
	
	
	public void SaveData() throws IOException {
		 ArrayList<String>names=new ArrayList<String>();
		 names=removeDups();
		 String filename=this.StoreName+"SoldOutStats.txt";
		 I_WriteArrayToFiles f=new WriteDataController();
		 f.writeData(names,filename);
	}
	
	
	public ArrayList<String> removeDups() throws IOException {
		 ArrayList<String>Newnames=new ArrayList<String>();
		 ArrayList<String>Oldnames=new ArrayList<String>();
		 Newnames=this.ProductNames;
		 Get_SoldOutStats();
		 Oldnames=getData();
		 for(int i=0; i<Newnames.size(); i++) {
			 for(int j=0; j<Oldnames.size(); j++) {
				 if(Newnames.get(i).equals(Oldnames.get(j))) {
					 Newnames.remove(i);
				 }
				 else
					 continue;
			 }
		 }
		 return Newnames;
	}
	
	
	
	public void Get_SoldOutStats() throws IOException {
		String filename=this.StoreName+"SoldOutStats.txt";
		 I_ReadFromFiles files= new ReadDataController();
		  this.ProductNames=files.readFile(filename);
	}
	
	
	public ArrayList<String> getData() {
		return this.ProductNames;
	}
	

}
