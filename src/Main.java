import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Hi");
		System.out.println("Press 1 to Register");
		System.out.println("Press 2 to Login");
		Scanner n = new Scanner(System.in);
		String username=null;
	    String password=null;
	    int key=0;
	    int choice=n.nextInt();
	    
	    //REGISTERATION
		if(choice==1) {
			Customer c1=new Customer();
			Adminstrator a1=new Adminstrator();
			StoreOwner s1=new StoreOwner();
			OnlineStoreOwner o1=new OnlineStoreOwner();
			System.out.println("1-Register as Customer ");
			System.out.println("2-Register as Adminstrator ");
			System.out.println("3-Register as StoreOwner ");
			System.out.println("4-Register as OnlineStoreOwner ");
			int choice1=n.nextInt();
		    switch(choice1) {
		    case 1:
		    	System.out.println("Enter your username:");
			    username=n.next();
				System.out.println("Enter your password: ");
			    password=n.next();
			    c1=new Customer(username,password);
			    c1.loginCust(username, password);
			    System.out.println("1-Buy Products");
			    System.out.println("2-Logout");
                int z=n.nextInt();
                if(z==1) {
                	c1.buy_Products();
                }
                else if(z==2) {
                	System.out.println("Successful Logout");
					return;
                }
                else {
					System.out.println("Please enter 1 or 2 only");

                }
				break;
				
		    case 2:
		    	System.out.println("Enter your username: ");
	            username=n.next();
				System.out.println("Enter your password:");
				password=n.next();
				System.out.println("Enter the admin key: ");
				key=n.nextInt();
				a1=new Adminstrator(key,username,password);
				a1.loginAdmin(username, password);
				System.out.println("1-Add Products: ");
				System.out.println("2-Add Brands ");
				System.out.println("3-View Users' Statistics");
				System.out.println("4-View Products' Statistics");
				System.out.println("5-Logout");
				int x=n.nextInt();
				if(x==1) {
					a1.setProductType();
				    }
				else if(x==2) {
					a1.addNewBrand();
				}
				else if(x==3) {
					a1.Users_Stats();
				}
				else if(x==4) {
					System.out.println("Enter the store name you want to view statistics for:");
					String storename= n.next();
					a1.Products_Stats(storename);
				}
				else if(x==5) {
					System.out.println("Successful Logout");
					return;
				}
				else {
					System.out.println("Please enter 1 or 2 or 3 only");
				}
				break;
				
		    case 3:
				System.out.println("Enter your username: ");
				username=n.next();
				System.out.println("Enter your password: ");
				password=n.next();
		        s1=new StoreOwner(username,password);
            	s1.loginNormalSO(username, password);
		        System.out.println("1-Add Store: ");
				System.out.println("2-Add Products: ");
				System.out.println("3-View Buying Statistics");
				System.out.println("4-Customer Viewing Statistics");
				System.out.println("5-View Sold Out Products");
				System.out.println("6-Logout");
				int r=n.nextInt();
                if(r==1) {
                	System.out.println("Enter your new store name,type and address");
                	String StoreName=n.next();
                	String type=n.next();
                	String address=n.next();
                	OnsiteStore s=new OnsiteStore(StoreName, type, address);
                	//s.setStoreInfo(StoreName, type, address);
                	s1.add_Normalstore(s);
                }
                else if(r==2) {
                	System.out.println("Enter your existing store name that products will be added to:");
                	String StoreName=n.next();
                	OnsiteStore os=new OnsiteStore(StoreName);
                	a1.setProductType();        
                	a1.addNewBrand();
                	s1.Add_NormalStoreProducts(os);
                	s1.Get_NormalStoreOwnerProducts();
                	}
                else if(r==3) {
                	s1.get_CustBuyStats();;
                }
                else if (r==4) {
                	s1.get_CustViewiStats();
                }
                else if(r==5) {
                	s1.get_SoldOutStats();
                }
                else if(r==6) {
					System.out.println("Successful Logout");
					return;
				}
				else {
					System.out.println("Please enter 1 or 2 or 3 only");
				}        
			    break;
				
			case 4:
				System.out.println("Enter your username: ");
				username=n.next();
				System.out.println("Enter your password:");
				password=n.next();
		        o1=new OnlineStoreOwner(username,password);
		        o1.loginOnlineSO(username, password);
		        System.out.println("1-Add Store: ");
				System.out.println("2-Add Products: ");
				System.out.println("3-View Buying Statistics");
				System.out.println("4-Customer Viewing Statistics");
				System.out.println("5-View Sold Out Products");
				System.out.println("6-Logout");
		        int y=n.nextInt();
                if(y==1) {
                	System.out.println("Enter your new store name and type");
                	String StoreName=n.next();
                	String type=n.next();
                	OnlineStore on=new OnlineStore(StoreName, type);
                	//on.setStoreInfo(StoreName, type);
                	System.out.println("ADMIN LOGS IN");
                	System.out.println("Enter Admin username: ");
    				String adminUsername=n.next();
    				System.out.println("Enter Admin password:");
    				String adminPassword=n.next();
                	a1.loginAdmin(adminUsername, adminPassword);
                	o1.add_OnlineStore(on);
                }
                else if(y==2) {
                	System.out.println("Enter your existing store name that products will be added to:");
                	String StoreName=n.next();
                	OnlineStore on=new OnlineStore(StoreName);
                	//on.setStore_Name(StoreName);
                	a1.setProductType();        
                	a1.addNewBrand();
                	o1.Add_OnlineStoreProducts(on);
                	o1.Get_OnlineStoreOwnerProducts();
                }
                else if(y==3) {
                	o1.get_CustBuyStats();;
                }
                else if (y==4) {
                	o1.get_CustViewiStats();
                }
                else if(y==5) {
                	o1.get_SoldOutStats();
                }
                else if(y==6) {
					System.out.println("Successful Logout");
					return;
				}
				else {
					System.out.println("Please enter 1 or 2 or 3 only");
				}
				break;	
				}
		}
		
		    //LOGIN
		    else if(choice==2) {
			Customer c2=new Customer();
			Adminstrator a2=new Adminstrator();
			StoreOwner s2=new StoreOwner();
			OnlineStoreOwner o2=new OnlineStoreOwner();
			System.out.println("1-Login as Customer ");
			System.out.println("2-Login as Adminstrator ");
			System.out.println("3-Login as StoreOwner ");
			System.out.println("4-Login as OnlineStoreOwner ");
			int choice2=n.nextInt();
		    switch(choice2) {
		    case 1:
		    	System.out.println("Enter your username:  ");
			    username=n.next();
				System.out.println("Enter your password:");
			    password=n.next();
				c2.Set_data(username, password);
				System.out.println("1-Buy Products");
			    System.out.println("2-Logout");
                int z=n.nextInt();
                if(z==1) {
                	c2.buy_Products();
                }
                else if(z==2) {
                	System.out.println("Successful Logout");
					return;
                }
                else {
					System.out.println("Please enter 1 or 2 only");

                }
				break;
			
				
		    case 2:
				System.out.println("Enter your username:  ");
				username=n.next();
				System.out.println("Enter your password:");
				password=n.next();
				a2.Set_data(username, password);
				System.out.println("1-Add Products: ");
				System.out.println("2-Add Brands ");
				System.out.println("3-View Users' Statistics");
				System.out.println("4-View Products' Statistics");				
				System.out.println("5-Logout");
				int x=n.nextInt();
				if(x==1) {
				  a2.setProductType();
				  }
				else if(x==2) {
					a2.addNewBrand();
				}
				else if(x==3) {
					a2.Users_Stats();
				}
				else if(x==4) {
					System.out.println("Enter the store name you want to view statistics for:");
					String storename=n.next(); 
					a2.Products_Stats(storename);
				}
				else if(x==5) {
					System.out.println("Successful Logout");
					return;
				}
				else {
					System.out.println("Please enter 1 or 2 or 3 only");
				}
				break;
				
				
		    case 3:
		    	System.out.println("Enter you username:  ");
				username=n.next();
				System.out.println("Enter your password:");
				password=n.next();
				s2.Set_data(username, password);
				System.out.println("1-Add Store: ");
				System.out.println("2-Add Products: ");
				System.out.println("3-View Buying Statistics");
				System.out.println("4-Customer Viewing Statistics");
				System.out.println("5-View Sold Out Products");
				System.out.println("6-Logout");
				int r=n.nextInt();
                if(r==1) {
                	System.out.println("Enter your new store name,type and address");
                	String StoreName=n.next();
                	String type=n.next();
                	String address=n.next();
                	OnsiteStore os=new OnsiteStore(StoreName, type, address);
                	//os.setStoreInfo(StoreName, type, address);
                	s2.add_Normalstore(os);
                }
                else if(r==2) {
                	System.out.println("Enter your existing store name that products will be added to:");
                	String StoreName=n.next();
                	OnsiteStore os=new OnsiteStore(StoreName);
                	//os.setStore_Name(StoreName);
                	a2.setProductType();
                	a2.addNewBrand();
                	s2.Add_NormalStoreProducts(os);
                	s2.Get_NormalStoreOwnerProducts();
                }
                else if(r==3) {
                	s2.get_CustBuyStats();;
                }
                else if (r==4) {
                	s2.get_CustViewiStats();
                }
                else if(r==5) {
                	s2.get_SoldOutStats();
                }
                else if(r==6) {
					System.out.println("Successful Logout");
					return;
				}
				else {
					System.out.println("Please enter 1 or 2 or 3 only");
				}
				break;
		    	
			case 4:
				System.out.println("Enter you username: ");
				username=n.next();
				System.out.println("Enter your password: ");
				password=n.next();
		        o2.Set_data(username, password);
		        System.out.println("1-Add Store: ");
				System.out.println("2-Add Products: ");
				System.out.println("3-View Buying Statistics");
				System.out.println("4-Customer Viewing Statistics");
				System.out.println("5-View Sold Out Products");
				System.out.println("6-Logout");
		        int y=n.nextInt();
                if(y==1) {
                	System.out.println("Enter your new store name and type: ");
                	String StoreName=n.next();
                	String type=n.next();
                	OnlineStore on=new OnlineStore(StoreName, type);
                	//on.setStoreInfo(StoreName, type);
                	System.out.println("ADMIN LOGS IN");
                	System.out.println("Enter Admin username: ");
    				String adminUsername=n.next();
    				System.out.println("Enter Admin password:");
    				String adminPassword=n.next();
                	a2.loginAdmin(adminUsername, adminPassword);
                	o2.add_OnlineStore(on);
                }
                else if(y==2) {
                	System.out.println("Enter your existing store name that products will be added to:");
                	String StoreName=n.next();
                	OnlineStore on=new OnlineStore(StoreName);
                	//on.setStore_Name(StoreName);
	              	a2.setProductType();        
                	a2.addNewBrand();
                	o2.Add_OnlineStoreProducts(on);
                	o2.Get_OnlineStoreOwnerProducts();
                }
                else if(y==3) {
                	o2.get_CustBuyStats();;
                }
                else if (y==4) {
                	o2.get_CustViewiStats();
                }
                else if(y==5) {
                	o2.get_SoldOutStats();
                }
                else if(y==6) {
					System.out.println("Successful Logout");
					return;
				}
				else {
					System.out.println("Please enter 1 or 2 or 3 only");
				}
				break;
				}
		    
		    
		} else {
			System.out.println("Please enter 1 or 2 only");
		}	
		
		
	   }

	}