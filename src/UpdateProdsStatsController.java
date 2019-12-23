import java.io.IOException;
import java.util.ArrayList;

public class UpdateProdsStatsController {

	private ArrayList<Products>products=new ArrayList<Products>();
	private String ProductName=null;
	private int ProductAmount=0;
	
	public UpdateProdsStatsController() {
		this.products=null;
	}
	
	public void Get_ProductStats(String filename) throws IOException {
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
	}
	
	
	public int getTotalProducts() {
		return this.products.size();
	}
	
	
	public int getProductAmount() {
		return this.ProductAmount;
	}

	public String getProductName() {
		return this.ProductName;
	}
	
}

