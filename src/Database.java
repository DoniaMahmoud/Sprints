import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
	protected static String CustomerUsername = "CustomerUsername.txt";
	protected static String CustomerPassword = "CustomerPassword.txt";
	protected static String AdminUsername = "AdminUsername.txt";
	protected static String AdminPassword = "AdminPassword.txt";
	protected static String StoreOwnerUsername = "StoreOwnerUsername.txt";
	protected static String StoreOwnerPassword = "StoreOwnerPassword.txt";
	protected static String OnlineStoreOwnerUsername = "OnlineStoreOwnerUsername.txt";
	protected static String OnlineStoreOwnerPassword = "OnlineStoreOwnerPassword.txt";
	protected static String NormalProductsList = "NormalProductsList.txt";
	protected static String OnlineProductsList = "OnlineProductsList.txt";
	protected static String BrandsList = "BrandsList.txt";
	private  ArrayList <Products> DataNormalProducts=new ArrayList <Products>();
	private  ArrayList <Products> DataOnlineProducts=new ArrayList <Products>();
	private  ArrayList <Brands> DataBrands=new ArrayList <Brands>();
	
	
	public void addNewProduct(String filename,int indicator,int s) throws IOException {
		Scanner r = new Scanner(System.in);
		String name;
		String category;
		String type;
		int price;
		File f2;
		if(filename=="NormalProductsList") {
			 f2 = new File(NormalProductsList);
		}
		else {
			 f2 = new File(OnlineProductsList);
		}
		
		for(int i=0; i<s; i++) {
			FileWriter fileWriter2= new FileWriter(f2,true);
			BufferedWriter bw2 =new BufferedWriter(fileWriter2);
			System.out.println("Enter ProductName, ProductCategory, ProductType and ProductPrice: ");
			name=r.next();
			category=r.next();
			type=r.next();
			price=r.nextInt();
			Products p=new Products(name,category,type,price);
			p.Generate_SerialNo();
			bw2.newLine();
			bw2.write(p.get_name());
			bw2.newLine();
			bw2.write((String.valueOf(p.get_SerialNo())));
			bw2.newLine();
		    bw2.write(p.get_category());
	        bw2.newLine();
	        bw2.write(p.get_type());
	        bw2.newLine();
		    bw2.write((String.valueOf(p.get_price())));
		    bw2.close();
		    System.out.println("Product added successfully!");
		}
	    
	    if(indicator==1) {
	    	Get_NormalProducts();
	    }
	    else if(indicator==2) {
	    	Get_OnlineProducts();
		    }
	}
	
	 public void  Get_NormalProducts() throws IOException {   
		 File file = new File(NormalProductsList);
			Scanner obj= new Scanner(file);
		    String name1;
		    String serial;
		    String category1;
		    String type1;
			String price1;	
			int v=0;
			while(obj.hasNextLine()) {
				v++;
				obj.nextLine();
			}
			int z=v/5;
			Scanner obj2= new Scanner(file);
			
			
			for(int i=0; i<z; i++) {
				name1=obj2.nextLine();
				serial=obj2.nextLine();
				category1=obj2.nextLine();
				type1=obj2.nextLine();
				price1=obj2.nextLine();
				Products p=new Products();
			    p.set(name1,category1,type1,Integer.parseInt(price1));
			    p.set_serial(Integer.parseInt(serial));
			    this.DataNormalProducts.add(p);
			}
			
			obj.close();
			obj2.close();
			Products p1=new Products();
			p1.setNormalProducts(this.DataNormalProducts);
		
	 }
	 
	 
	 public void  Get_OnlineProducts() throws IOException{
		 File file = new File(OnlineProductsList);
		 Scanner obj= new Scanner(file);
		    String name1;
		    String serial;
		    String category1;
		    String type1;
			String price1;	
			int v=0;
			while(obj.hasNextLine()) {
				v++;
				obj.nextLine();
			}
			int z=v/5;
			Scanner obj2= new Scanner(file);
			
			
			for(int i=0; i<z; i++) {
				name1=obj2.nextLine();
				serial=obj2.nextLine();
				category1=obj2.nextLine();
				type1=obj2.nextLine();
				price1=obj2.nextLine();
				Products p=new Products();
			   p.set(name1,category1,type1,Integer.parseInt(price1));
			   p.set_serial(Integer.parseInt(serial));
			    this.DataOnlineProducts.add(p);
			}
			
			obj.close();
			obj2.close();
			Products p1=new Products();
			p1.setOnlineProducts(this.DataOnlineProducts);
		 
	 }
	
	
	
	 public void Add_NewBrand(int s) throws IOException {
		  Scanner r = new Scanner(System.in);
		  String name;
		  String category;
		  Brands b;
		  File f2 = new File(BrandsList);
			FileWriter fileWriter2= new FileWriter(f2,true);
			BufferedWriter bw2 =new BufferedWriter(fileWriter2);
			for(int i=0; i<s; i++) {
				System.out.println("Enter BrandName and BrandCategory: ");
				name=r.next();
				category=r.next();
				b=new Brands(name,category);
				bw2.write(b.getBrandName());
				bw2.newLine();
				bw2.write(b.getBrandCategory());
				bw2.newLine();
			    System.out.println("Brand added successfully!");
			}
		    bw2.close();
		    
		    Get_Brands();
		    
		}
	 
	 
	 public void Get_Brands() throws IOException {
	    File file = new File(BrandsList);
		Scanner obj= new Scanner(file);
		int v=0;
		while(obj.hasNextLine()) {
			v++;
			obj.nextLine();
		}
		int z=v/2;
		Scanner obj2= new Scanner(file);
	    String name1;
	    String category1;
		for(int i=0; i<z; i++) {
			name1=obj2.nextLine();
			category1=obj2.nextLine();
			Brands b=new Brands();
			b.set(name1,category1);
			this.DataBrands.add(b);
		}
		obj.close();
		obj2.close();
		Brands b1=new Brands();
		b1.setBrands(this.DataBrands);
  
		  
	 }
	 
	 
	  public static void create_UserPath(String username) throws IOException {
		   // String path="C:\\Users\\Youss\\Desktop\\Sprints\\";
			String path="";
			path=path.concat(username);
			path=path.concat(".txt");
			File file = new File(path);
			file.createNewFile();
			
	}
	 
	  
	  
	  
	  public static void create_OnsiteStorePath(OnsiteStore s) throws IOException {
		  //String path="C:\\Users\\Youss\\Desktop\\Sprints\\";
		 String path="";
		 path=path.concat(s.getStore_Name());
		  path=path.concat(".txt");
		  File file = new File(path);
			if(file.createNewFile()) {
				System.out.println("Store Added Successfully");
			}
			else {
				System.out.println("Store name is taken. Try a different one: ");
				Scanner n=new Scanner(System.in);
				String StoreName=n.next();
				s.setStore_Name(StoreName);
				StoreOwner r=new StoreOwner();
				r.add_Normalstore(s);
				
			}
	  }
	  
	  
	  public static void create_OnlineStorePath(OnlineStore s) throws IOException {
		  //String path="C:\\Users\\Youss\\Desktop\\Sprints\\";
		  String path="";
		  path=path.concat(s.getStore_Name());
		  path=path.concat(".txt");
		  File file = new File(path);
			if(file.createNewFile()) {
				System.out.println("Store Added Successfully");
			}
			else {
				System.out.println("Store name is taken. Try a different one: ");
				Scanner n=new Scanner(System.in);
				String StoreName=n.next();
				s.setStore_Name(StoreName);
				OnlineStoreOwner r=new OnlineStoreOwner();
				r.add_OnlineStore(s);
				
			}
	  }
	  
	  
	  
	  
	  /*
	  public static void create_StorePath(Store s,int indicator) throws IOException {
		    String path="D:\\1st TERM Year(3)\\Software Eng2\\Project\\";
		    if(indicator==1) {
				path=path.concat(new OnsiteStore().getStore_Name());
				path=path.concat(".txt");
				File file = new File(path);
				if(file.createNewFile()) {
					System.out.println("Store Added Successfully");
				}
				else {
					System.out.println("Store name is taken. Try a different one: ");
					Scanner n=new Scanner(System.in);
					String StoreName=n.next();
					s=new OnsiteStore()
					StoreOwner r=new StoreOwner();
					r.add_Normalstore(StoreName);
				
		    }
			path=path.concat(StoreName);
			path=path.concat(".txt");
			File file = new File(path);
			if(file.createNewFile()) {
				System.out.println("Store Added Successfully");
			}
			else {
				System.out.println("Store name is taken. Try a different one: ");
				Scanner s=new Scanner(System.in);
				StoreName=s.next();
				if(indicator==1) {
					StoreOwner r=new StoreOwner();
					
					r.add_Normalstore(StoreName);
				}
				else {
					OnlineStoreOwner r=new OnlineStoreOwner();
					r.add_OnlineStore(StoreName);
				}
				return;
			}
			
	}
	
	*/
	  
	  public static ArrayList <OnsiteStore> get_Onsitestores(String filename) throws IOException{
		    ArrayList<OnsiteStore> stores= new ArrayList <OnsiteStore>();
		    File f2 = new File(filename);
			Scanner obj2= new Scanner(f2);
			Scanner obj= new Scanner(f2);
			String name;
			String type;
			String address;
			int v=0;
			while(obj.hasNextLine()) {
				v++;
				obj.nextLine();
			}
			int z=v/3;
			
			for(int i=0; i<z; i++) {
				name=obj2.nextLine();
				type=obj2.nextLine();
				address=obj2.nextLine();
				OnsiteStore s=new OnsiteStore(name,type,address);
				//s.setStoreInfo(name,type,address);
				stores.add(s);
			}
			
			obj2.close();
			return stores;
			
			
	  }
	  
	  
	  
	  
	  public static ArrayList <OnlineStore> get_Onlinestores(String filename) throws IOException{
		  ArrayList<OnlineStore> stores= new ArrayList <OnlineStore>();
		    File f2 = new File(filename);
			Scanner obj2= new Scanner(f2);
			Scanner obj= new Scanner(f2);
			String name;
			String type;
			int v=0;
			while(obj.hasNextLine()) {
				v++;
				obj.nextLine();
			}
			int z=v/2;
			
			for(int i=0; i<z; i++) {
				name=obj2.nextLine();
				type=obj2.nextLine();
				OnlineStore s=new OnlineStore(name,type);
			//	s.setStoreInfo(name,type);
				stores.add(s);
			}
			
			obj2.close();
			return stores;
			
			
	  }
	  
	  
	  
	  
	  public static void AddOnsiteStores(OnsiteStore s,String filename) throws IOException{
		    File f2 = new File(filename);
			FileWriter fileWriter2= new FileWriter(f2,true);
			BufferedWriter bw2 =new BufferedWriter(fileWriter2);
			bw2.write(s.getStore_Name());
			bw2.newLine();
			bw2.write(s.getStore_Type());
			bw2.newLine();
			bw2.write(s.getStore_Address());
			bw2.newLine();
		    bw2.close();
			
	  }
	  
	  public static void AddOnlineStores(OnlineStore s,String filename) throws IOException{
		    File f2 = new File(filename);
			FileWriter fileWriter2= new FileWriter(f2,true);
			BufferedWriter bw2 =new BufferedWriter(fileWriter2);
			bw2.write(s.getStore_Name());
			bw2.newLine();
			bw2.write(s.getStore_Type());
			bw2.newLine();
		    bw2.close();
			
	  }
	  
	  /*
	  public static void AddStores(Store s,String filename,int indicator) throws IOException{
		    File f2 = new File(filename);
			FileWriter fileWriter2= new FileWriter(f2,true);
			BufferedWriter bw2 =new BufferedWriter(fileWriter2);
			if(indicator==1) {
				bw2.write(new OnsiteStore().getStore_Name());
				bw2.newLine();
				bw2.write(new OnsiteStore().getStore_Type());
				bw2.newLine();
				bw2.write(new OnsiteStore().getStore_Address());
				bw2.newLine();
			    bw2.close();
			}
			else if(indicator==2) {
				bw2.write(new OnlineStore().getStore_Name());
				bw2.newLine();
				bw2.write(new OnlineStore().getStore_Type());
				bw2.newLine();
			    bw2.close();
			}
		
		 
	  }
	  
	  */
	  
	  public static void AddProductsToStores(String StoreName,ArrayList<Products>list) throws IOException{
		    String filename2=StoreName+".txt";
			File f2 = new File(filename2);
			FileWriter fileWriter2= new FileWriter(f2,true);
			BufferedWriter bw2 =new BufferedWriter(fileWriter2);
			for(int i=0; i<list.size(); i++) {
				 bw2.write(list.get(i).get_name());
				 bw2.newLine();
				 bw2.write(String.valueOf(list.get(i).get_SerialNo()));
				 bw2.newLine();
				 bw2.write(list.get(i).get_category());
				 bw2.newLine();
				 bw2.write(list.get(i).get_type());
				 bw2.newLine();
				 bw2.write(list.get(i).get_Brand().getBrandName());
				 bw2.newLine();
				 bw2.write(list.get(i).get_Brand().getBrandCategory());
				 bw2.newLine();
				 bw2.write(String.valueOf(list.get(i).get_price()));
				 bw2.newLine();
				 bw2.write(String.valueOf(list.get(i).get_amount()));
				 bw2.newLine();
			}			
			 bw2.close();
			 
		    
	  }
	  
	 
	  /*
	  public static void Assign_Brands(String StoreName,ArrayList <String>list)throws IOException{
		    Scanner n=new Scanner(System.in);
		    String filename=StoreName+".txt";
			File f1 = new File(filename);
			FileWriter fileWriter2= new FileWriter(f1,true);
			BufferedWriter bw2 =new BufferedWriter(fileWriter2);
			File f2 = new File(filename);
			Scanner obj2= new Scanner(f2);
			String name;
			String category;
			String price;
			String amount;
			while(obj2.hasNextLine()) {
				name=obj2.nextLine();
				System.out.print("Product Name: ");
				System.out.println(name);
				category=obj2.nextLine();
				System.out.print("Category: ");
				System.out.println(category);
				price=obj2.nextLine();
				System.out.print("Price: ");
				System.out.println(price);
				amount=obj2.nextLine();
				System.out.print("Amount: ");
				System.out.println(amount);
				System.out.println("Enter the brand name you want to assign to this product to: ");
				String Bname=n.next();
				String Bcategory;
				int v=0;
				for(int i=0; i<list.size(); i+=2) {
					if(Bname.equals(list.get(i))) {
						Bcategory=list.get(i+1);
						bw2.write(Bname);
						bw2.newLine();
						bw2.write(Bcategory);
						bw2.newLine();
						v=1;
					}
					else {
						continue;
					}
				}
				if(v!=1) {
					System.out.println("Please type a brand name that exists in the previous list");
					Bname=n.next();
					for(int i=0; i<list.size(); i+=2) {
						if(Bname.equals(list.get(i))) {
							Bcategory=list.get(i+1);
							bw2.write(Bname);
							bw2.newLine();
							bw2.write(Bcategory);
							bw2.newLine();
							v=1;
						}
						else {
							continue;
						}
				}
				}
				
			}
	  
	  bw2.close();
	  }
	  
	  */
	  
	  
	  public static void  GetStoreProducts(String StoreName)throws IOException{
		    ArrayList<Products> list=new ArrayList <Products>();
		    String filename2=StoreName+".txt";
			File f2 = new File(filename2);
			Scanner obj= new Scanner(f2);
			Scanner obj2= new Scanner(f2);
			String name;
			String serial;
			String category;
			String type;
			Brands b=new Brands();
			String price;
			String amount;
			int v=0;
			while(obj.hasNextLine()) {
				v++;
				obj.nextLine();
			}
			int z=v/8;
			for(int i=0; i<z; i++) {
				name=obj2.nextLine();
				serial=obj2.nextLine();
				category=obj2.nextLine();
				type=obj2.nextLine();
				b.setBrandName(obj2.nextLine());
				b.setBrandCategory(obj2.nextLine());
				price=obj2.nextLine();
				amount=obj2.nextLine();
				Products p=new Products(name,Integer.parseInt(serial),category,type,b,Integer.parseInt(price),Integer.parseInt(amount));
			    //p.set(name,category,type,Integer.parseInt(price));
			    list.add(p);
			    
			}
			
			obj.close();
			obj2.close();
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i).get_name());
				System.out.println(list.get(i).get_SerialNo());
				System.out.println(list.get(i).get_category());
				System.out.println(list.get(i).get_type());
				System.out.println(list.get(i).get_Brand().getBrandName());
				System.out.println(list.get(i).get_Brand().getBrandCategory());
				System.out.println(list.get(i).get_price());
				System.out.println(list.get(i).get_amount());
				
			}
	  } 
	  
	  
	  public static ArrayList<String> get_OnsiteStoreNames() throws IOException{
		 String filename= "StoreOwnerUsername.txt";
		 File file = new File(filename);
		 ArrayList <String> OnsiteStoreNames=new ArrayList<String>();
		 ArrayList <String> StoreOwners=new ArrayList<String>();
		 Scanner s=new Scanner(file);
		 String read=null;
		 while(s.hasNextLine()) {
			 read=s.nextLine();
			 StoreOwners.add(read);
		 }
		 /*
		 String filename2= "OnlineStoreOwnerUsername.txt";
		 File file2 = new File(filename2);
		 Scanner s2=new Scanner(file);
		 String read2=null;
		 while(s2.hasNextLine()) {
			 read2=s2.nextLine();
			 Owners.add(read2);
			 */
		 
		 
		 for(int i=0; i<StoreOwners.size(); i++) {
			 String path=StoreOwners.get(i);
			 path=path.concat(".txt");
			 File f=new File(path);
			 Scanner n=new Scanner(f);
			 String store=null;
			 while(n.hasNextLine()) {
				 store=n.nextLine();
				 if(store=="") {
					 break;
				 }
				 else {
					 OnsiteStoreNames.add(store);
					 n.nextLine();
					 n.nextLine();				 }	 
			 }
		 }
		 
		 
		 return OnsiteStoreNames;
	  }
	  
	  
	  
	  
	  public static ArrayList<String> get_OnlineStoreNames() throws IOException{			 
			 String filename2= "OnlineStoreOwnerUsername.txt";
			 ArrayList <String> OnlineStoreNames=new ArrayList<String>();
			 ArrayList <String> OnlineStoreOwners=new ArrayList<String>();
			 File file2 = new File(filename2);
			 Scanner s2=new Scanner(file2);
			 String read2=null;
			 while(s2.hasNextLine()) {
				 read2=s2.nextLine();
				 OnlineStoreOwners.add(read2);
			 }
			 
			 
			 for(int i=0; i<OnlineStoreOwners.size(); i++) {
				 String path=OnlineStoreOwners.get(i);
				 path=path.concat(".txt");
				 File f=new File(path);
				 Scanner n=new Scanner(f);
				 String store=null;
				 while(n.hasNextLine()) {
					 store=n.nextLine();
					 if(store=="") {
						 break;
					 }
					 else {
						 OnlineStoreNames.add(store);
						 n.nextLine();
					 }	 
				 }
			 }
			 
			 
			 return OnlineStoreNames;
		  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
   public static void WriteRegData(String username,String usernamefile,String password,String passwordfile, int indicator) throws IOException {
	 File f1 = new File(usernamefile);
		FileWriter fileWriter1= new FileWriter(f1,true);
		BufferedWriter bw1 =new BufferedWriter(fileWriter1);
		bw1.newLine();
	    bw1.write(username);
	    bw1.close();
	    if(indicator!=1) {
	    	Database.create_UserPath(username);
	    }
	    
		
		File f2 = new File(passwordfile);
		FileWriter fileWriter2= new FileWriter(f2,true);
		BufferedWriter bw2 =new BufferedWriter(fileWriter2);
		bw2.newLine();
		bw2.write(password);
	    bw2.close();
	  }
	  
	  
	  
	  
	  
	  
	  
}