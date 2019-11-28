import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public interface StoreOwnerFuncs {

	public static boolean search_Onsitestores(OnsiteStore s,String filename) throws IOException {
		ArrayList<OnsiteStore> stores= new ArrayList <OnsiteStore>();
		stores=Database.get_Onsitestores(filename);
		for(int i=0; i<stores.size(); i++) {
			if(s.getStore_Name().equals(stores.get(i).getStore_Name())){
				return true;
			}
			else {
				continue;
				}	
		}
		return false;
		
		
	}
	
	
	public static boolean search_Onlinestores(OnlineStore s,String filename) throws IOException {
		ArrayList<OnlineStore> stores= new ArrayList <OnlineStore>();
		stores=Database. get_Onlinestores(filename);
		for(int i=0; i<stores.size(); i++) {
			if(s.getStore_Name().equals(stores.get(i).getStore_Name())){
				return true;
			}
			else {
				continue;
				}	
		}
		return false;
		
		
	}
	
	
	
	public static void add_OnsiteStore(OnsiteStore s,String filename) throws IOException {
		Database.create_OnsiteStorePath(s);
		Database.AddOnsiteStores(s, filename);
		
	}
	
	
	
	public static void add_OnlineStore(OnlineStore s,String filename) throws IOException {
			if(Adminstrator.approveOnlineStore()==true) {
				Database.create_OnlineStorePath(s);
				Database.AddOnlineStores(s, filename);  
			}
			
			else {
				System.out.println("The Store was rejected by the adminstrator.");
			}
			
		}
		
	

	
	public static void Add_OnsiteProducts(OnsiteStore s,String filename) throws IOException {
		ArrayList <Products> list=new ArrayList <Products>();
		ArrayList <Products> ChosenList=new ArrayList <Products>();
		Products p = new Products();
		list= p.get_AllProducts();	
		Scanner n= new Scanner(System.in);
		int r;
	    if(search_Onsitestores(s,filename)==false) {
			System.out.println("You don't have a store with this name.Enter a name of a store you own: ");
			String StoreName=n.next();
			s.setStore_Name(StoreName);
			Add_OnsiteProducts(s,filename);
			return;
		}
	    
	    else {
			System.out.println("Here is the list of products available on the plateform: " );
			for(int i=0; i<list.size(); i++ ) {
				System.out.print("Product Name: ");
				System.out.println(list.get(i).get_name());
				System.out.print("Product SerialNo: ");
				System.out.println(list.get(i).get_SerialNo());
				System.out.print("Category: ");
				System.out.println(list.get(i).get_category());
				System.out.print("Type: ");
				System.out.println(list.get(i).get_type());
				System.out.print("Price: ");
				System.out.println(list.get(i).get_price());
			}
				
			System.out.println("Enter the serial number of the product you want to add to you store or press 0 to stop");
				r=n.nextInt();
				while(r!=0) {
					for(int i=0; i<list.size(); i++) {
						if(r==list.get(i).get_SerialNo()) {
							System.out.println("Enter the amount you want: ");
							int amount=n.nextInt();
							Brands m= AssignBrands();
							while(m.getBrandName()=="" && m.getBrandCategory()=="") {
								System.out.println("Invalid BrandName.");
								m=AssignBrands();
							}
							String name=list.get(i).get_name();
							int serialNo= list.get(i).get_SerialNo();
							String category=list.get(i).get_category();
							String type=list.get(i).get_type();
							int price=list.get(i).get_price();
							Products p1=new Products(name,serialNo,category,type,m,price,amount);
							ChosenList.add(p1);
							break;
						}
						else continue;
					}
					if(ChosenList.equals(null)) {
						System.out.println("Invalid serial no. Please enter a vaid one");
						r=n.nextInt();
					}
					else {
						r=n.nextInt();
					}									
				}
				Database.AddProductsToStores(s.getStore_Name(), ChosenList);
			
	}
	}		
	
	
	
	
	public static void Add_OnlineProducts(OnlineStore s,String filename) throws IOException {
		ArrayList <Products> list=new ArrayList <Products>();
		ArrayList <Products> ChosenList=new ArrayList <Products>();
		Products p = new Products();
		list= p.get_OnlineProducts();
		Scanner n= new Scanner(System.in);
		int r;
	    if(search_Onlinestores(s,filename)==false) {
			System.out.println("You don't have a store with this name.Enter a name of a store you own: ");
			String StoreName=n.next();
			s.setStore_Name(StoreName);
			Add_OnlineProducts(s,filename);
			return;
		}
	    
	    else {
			System.out.println("Here is the list of products available on the plateform: " );
			for(int i=0; i<list.size(); i++ ) {
				System.out.print("Product Name: ");
				System.out.println(list.get(i).get_name());
				System.out.print("Product SerialNo: ");
				System.out.println(list.get(i).get_SerialNo());
				System.out.print("Category: ");
				System.out.println(list.get(i).get_category());
				System.out.print("Type: ");
				System.out.println(list.get(i).get_type());
				System.out.print("Price: ");
				System.out.println(list.get(i).get_price());
			}
				
			System.out.println("Enter the serial number of the product you want to add to you store or press 0 to stop");
				r=n.nextInt();
				while(r!=0) {
					for(int i=0; i<list.size(); i++) {
						if(r==list.get(i).get_SerialNo()) {
							System.out.println("Enter the amount you want: ");
							int amount=n.nextInt();
							Brands m= AssignBrands();
							while(m.getBrandName()=="" && m.getBrandCategory()=="") {
								System.out.println("Invalid BrandName.");
								m=AssignBrands();
							}
							String name=list.get(i).get_name();
							int serialNo= list.get(i).get_SerialNo();
							String category=list.get(i).get_category();
							String type=list.get(i).get_type();
							int price=list.get(i).get_price();
							Products p1=new Products(name,serialNo,category,type,m,price,amount);
							ChosenList.add(p1);
							break;
						}
						else continue;
					}
					if(ChosenList.equals(null)) {
						System.out.println("Invalid serial no. Please enter a vaid one");
						r=n.nextInt();
					}
					else {
						r=n.nextInt();
					}
					
				}
				Database.AddProductsToStores(s.getStore_Name(), ChosenList);

			
	}
	}		
		


	
	
	
    public static Brands AssignBrands()throws IOException{
    	Scanner n=new Scanner(System.in);
    	Brands b=new Brands();
		Database d=new Database();
		ArrayList<Brands> BrandsList=new ArrayList <Brands>();
		d.Get_Brands();
		BrandsList=b.get_Brands();
    	System.out.println("Here is the list of brands. Enter the brand name you want to assign your product to: ");
		for(int j=0; j<BrandsList.size(); j++) {
			System.out.print("BrandName: ");
			System.out.println(BrandsList.get(j).getBrandName());
			System.out.print("BrandCategory: ");
			System.out.println(BrandsList.get(j).getBrandCategory());
		}
		String brandname=n.next();
		Brands m=new Brands();
		for(int j=0; j<BrandsList.size(); j++) {
			if(brandname.equals(BrandsList.get(j).getBrandName())) {
				m.setBrandName(brandname);
				m.setBrandCategory(BrandsList.get(j).getBrandCategory());
			}
			else {
				continue;
			}
		}
		
		return m;
		
	}
    
    
    
    
    public static void get_OnsiteStoreProducts(String filename) throws IOException {
    	Scanner n=new Scanner(System.in);
		System.out.println("Please enter the name of the store you want to view products from: ");
		String StoreName=n.next();
		OnsiteStore s=new OnsiteStore(StoreName);
		//s.setStore_Name(StoreName);
		if(search_Onsitestores(s,filename)==false) {
			System.out.println("You don't have a store with this name.");
			get_OnsiteStoreProducts(filename);
			return;
		}
		else {
			Database.GetStoreProducts(StoreName);
		}
		
	}
    
    public static void get_OnlineStoreProducts(String filename) throws IOException {
    	Scanner n=new Scanner(System.in);
		System.out.println("Please enter the name of the store you want to view products from: ");
		String StoreName=n.next();
		OnlineStore s=new OnlineStore(StoreName);
		//s.setStore_Name(StoreName);
		if(search_Onlinestores(s,filename)==false) {
			System.out.println("You don't have a store with this name.");
			get_OnlineStoreProducts(filename);
			return;
		}
		else {
			Database.GetStoreProducts(StoreName);
		}
		
	}
    
    
    
    
    
    
    }