import java.io.IOException;
import java.util.Scanner;

public class Adminstrator extends User{
	private final int key=3456;
	
	public Adminstrator(){
		this.username="";
		this.password="";
	}
	
	
	public Adminstrator(int key,String username,String password) throws IOException {
		this.username=username;
		this.password=password;
	}
	
	public void set_key() throws IOException {
		I_SystemMessages s=new AdminstratorKey();
		s.messages();
		I_ReturnIntChoices r=new AdminstratorKey();
		int k=r.get_choice();
		verifyKey(k);
	}
	
	
	
	public void Set_data(String username,String password) throws IOException {
		this.username=username;
		this.password=password;
		set_key();
	}

	
	public void verifyKey(int key) throws IOException {
		if(key!=this.key) {
			System.out.println("Wrong key. You are NOT an adminstrator!");
			System.exit(1);
		}
	}
	
  
	public void addNewProduct(Products p) throws IOException {
		  String type=p.get_type();
		  String filename="";
		  if(type.equals("normal")) {
			  filename=NormalProductsList;
		  }
		  else {
			  filename=OnlineProductsList;
		  }
		  I_WriteProdsToFiles w=new WriteNewProductsController();
		  w.WriteProducts(filename, p);
		}
	  
	
	
	 public void addNewBrand(Brands b) throws IOException {
		 String filename=BrandsList;
		 I_WriteBrandsToFiles w=new WriteNewBrandsController();
		 w.WriteBrands(filename, b);
	  }
	  
	 public static boolean approveOnlineStore () throws IOException {
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter admin approval:");
			String input=scanner.next();
			if(input.equals("add")) {
				return true;
			}
			else  {
				return false;
			}
		  
		  }

	

}
