import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Adminstrator extends User {
	private final int key=3456;
	//private  ArrayList <String> NormalProducts=new ArrayList <String>();
	//private  ArrayList <String> OnlineProducts=new ArrayList <String>();
	//private  ArrayList <String> Brands=new ArrayList <String>();
	
	
	public Adminstrator(){
		this.username="";
		this.password="";
	}
	
	
	public Adminstrator(int key,String username,String password) throws IOException {
		this.username=username;
		this.password=password;
		registerAdmin(key,this.username,this.password);
	}
	
	public void Set_data(String username,String password) throws IOException {
		this.username=username;
		this.password=password;
		loginAdmin(this.username,this.password);
	}
	
	
	
	
	public void registerAdmin (int key,String username,String password) throws IOException {
		verifyKey(key,username,password);
	}
	
	
	
	public void verifyKey(int key,String username,String password) throws IOException {
		if(key!=this.key) {
			System.out.println("Wrong key. You can't register as an adminstrator!");
			return;
		}
		else {
			register(username,password,1);
		}
		
	}
	
   

	public void loginAdmin(String username, String password) throws IOException {
		login(username,password,1);
	}
	
	

 
   public void setProductType() throws IOException {
	  Scanner n= new Scanner(System.in);
	  System.out.println("Press 1 to add normal products or 2 to add online products: ");
	  int i=n.nextInt();
	  if(i==1) {
			  addNewProduct("NormalProductsList",1);
		  }
	  else {
			  addNewProduct("OnlineProductsList",2);
		}
		
	  
	  System.out.println("Press 0 to return to the main menu or -1 to exit: ");
	  i=n.nextInt();
	  if(i==0) {
		  setProductType();
		  return;
	  }
	  else {
		  return;
	  }
  }
  
  
  


  public void addNewProduct(String filename,int indicator) throws IOException {
	  Scanner r = new Scanner(System.in);
	  System.out.println("Enter no. of products you want to add: ");
	  int s=r.nextInt();
	  Database d= new Database();
	  d.addNewProduct(filename,indicator,s);
	}
  
  
  
  public void addNewBrand() throws IOException {
	  Scanner r = new Scanner(System.in);
	  System.out.println("Enter no. of brands you want to add: ");
	  int s=r.nextInt();
	  Database d= new Database();
	  d.Add_NewBrand(s);
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


  
  public void Users_Stats() throws IOException {
	  ArrayList<String>StoreOwners=new ArrayList<String>();
	  ArrayList<String>OnlineStoreOwners=new ArrayList<String>();
	  ArrayList<String>Customers=new ArrayList<String>();
	  File f=new File("StoreOwnerUsername.txt");
	  Scanner obj=new Scanner(f);
	  String read=null;
	  while(obj.hasNextLine()) {
		  read=obj.nextLine();
		  StoreOwners.add(read);
	  }
	  obj.close();
	  
	  f=new File("OnlineStoreOwnerUsername.txt");
	  obj=new Scanner(f);
	  while(obj.hasNextLine()) {
		  read=obj.nextLine();
		  OnlineStoreOwners.add(read);
	  }
	  obj.close();
	  
	  f=new File("CustomerUsername.txt");
	  obj=new Scanner(f);
	  while(obj.hasNextLine()) {
		  read=obj.nextLine();
		  Customers.add(read);
	  }
	  obj.close();
	  
	  
	  
	  int TotatlCustomers=Customers.size();
	  int TotatlOnlineStoreOwners=OnlineStoreOwners.size();
	  int TotalStoreOwners=StoreOwners.size();
	  int TotalUsers=TotatlCustomers+TotatlOnlineStoreOwners+TotalStoreOwners;
	  
	  
	  
	  System.out.println("The total number of customers: "+TotatlCustomers);
	  System.out.println("The total number of StoreOwners: "+TotalStoreOwners);
	  System.out.println("The total number of OnlineStoreOwners: "+TotatlOnlineStoreOwners);
	  System.out.println("The total number of Users: "+TotalUsers);
	  
  }
  
  public void Products_Stats(String storename) throws IOException{
	  String filename=storename+".txt";
	  File f=new File(filename);
	  Scanner obj=new Scanner(f);
	  Scanner obj2=new Scanner(f);
	  int v=0;
	  int SumOfProducts;
	  while(obj2.hasNextLine()) {
		  v++;
		  obj2.nextLine();
	  }
	  obj2.close();
	  SumOfProducts=v/8;
	  ArrayList<Products>StoreProducts=new ArrayList<Products>();
	  String name;
	  String serial;
	  String category;
	  String type;
	  Brands b=new Brands();
	  String price;
	  String amount;
	  int index=0;
	  for(int i=0; i<SumOfProducts; i++) {
	    name=obj.nextLine();
		serial=obj.nextLine();
		category=obj.nextLine();
		type=obj.nextLine();
		b.setBrandName(obj.nextLine());
		b.setBrandCategory(obj.nextLine());
		price=obj.nextLine();
		amount=obj.nextLine();
		Products p=new Products(name,Integer.parseInt(serial),category,type,b,Integer.parseInt(price),Integer.parseInt(amount));
		StoreProducts.add(p);	
	  }
	  int maxAmount=0;
	  for(int i=0; i<StoreProducts.size(); i++) {
		  if(StoreProducts.get(i).get_amount()>maxAmount) {
			  maxAmount=StoreProducts.get(i).get_amount();
			  index=i;
		  }
	  }
	 String Productname=StoreProducts.get(index).get_name();
	  
	  System.out.println("The Number of Products in this store is: "+SumOfProducts);
	  System.out.println("The Product with the highest stock is: "+Productname);
	  System.out.println("And its amount in stock is: "+maxAmount);
	  
	  obj.close();
  }
  
  
  
  /*
  public void getNormalProducts() throws IOException {
	  Database d=new Database();
	  d.Get_NormalProducts();
		
}
  
  
  public void getOnlineProducts() throws IOException {	
	  Database d=new Database();
	  d.Get_OnlineProducts();
		
}
  
  public void getBrands() throws IOException {
	  Database d=new Database();
	  d.Get_Brands();
}
  */

  
  
}