import java.io.IOException;
import java.util.ArrayList;
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
	
	
	public void SetData(String username,String password) {
		this.username=username;
		this.password=password;
	}
	
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
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

	 
	 public void UserStats(ArrayList<String>Data ) {
		 System.out.println("The total number of customers: "+Data.get(0));
		 System.out.println("The total number of OnlineStoreOwners: "+Data.get(1));
		  System.out.println("The total number of StoreOwners: "+Data.get(2));
		  System.out.println("The total number of Users: "+Data.get(3));
	 }
	
	 
	 public void ProdsStats(ArrayList<String>Data) {
		 if(Data==null) {
			 System.out.println("No products added in this store yet.");
		 }
		 else {
			 System.out.println("The Number of Products in this store is: "+Data.get(0));
			 System.out.println("The Product with the highest stock is: "+Data.get(1));
			 System.out.println("And its amount in stock is: "+Data.get(2)); 
		 }
	 }

	 
	 
	 
}
