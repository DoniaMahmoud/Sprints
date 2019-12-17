import java.io.IOException;
import java.util.ArrayList;

public class UpdateStoreController {
	private String StoreName;
	private ArrayList<Products>products=new ArrayList<Products>();
	private Products p;
	private int position;
	
	public UpdateStoreController(String storename,Products p,ArrayList<Products>products,int pos) {
		this.StoreName=storename;
		this.p=p;
		this.products=products;
		this.position=pos;
	}
	
	public void UpdateProductsList() throws IOException {
		this.products.add(this.position, this.p);
		String filename=this.StoreName+".txt";
		I_UpdateStoreProducts u=new UpdateProdsInFilesController();
		for(int i=0; i<this.products.size(); i++) {
			u.UpdateFile(filename,this.products.get(i));
		}
	}
	
	
	
}

