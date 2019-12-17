import java.io.IOException;
import java.util.ArrayList;

public class Brands extends Database{

	private String BrandName;
	private String BrandCategory;
	public static ArrayList <Brands> ListBrands=new ArrayList <Brands>();
	
	
	 public Brands() {
	    	this.BrandName="";
	    	this.BrandCategory="";
	    }

	
	  public Brands(String BrandName, String BrandCategory) {
	 	 this.BrandName=BrandName;
	 	 this.BrandCategory=BrandCategory;
	 }
	 
	  public void set(String BrandName,String BrandCategory) {
	 	 this.BrandName=BrandName;
	 	 this.BrandCategory=BrandCategory;
	 }
 
	  
	  
	  
	  public void setBrandName(String brandname) {
		  this.BrandName=brandname;
	  }
	  
	  public void setBrandCategory(String brandcategory) {
		  this.BrandCategory=brandcategory;
	  }
	  
	  
	  public String getBrandName() {
		  return this.BrandName;
	  }
	  
	  public String getBrandCategory() {
		  return this.BrandCategory;
	  }
	  
 
	  public void setBrands() throws IOException {	
		  String filename=BrandsList;
		  I_ReadBrandsFromFiles r=new ReadBrandsController();
		  ListBrands=r.readBrands(filename);
			
	}
	
	  
	  public void printComp(Brands b) {
			System.out.println(b.BrandName);
			System.out.println(b.BrandCategory);
		}

	
	
	  public ArrayList<Brands> get_Brands() throws IOException{
		    setBrands(); 
			return ListBrands;
		}
	
	
	
	
	
}