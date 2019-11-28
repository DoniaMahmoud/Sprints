import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineStoreOwner extends User {
	//private ArrayList<String> products= new ArrayList<String>();
	private ArrayList<OnlineStore> stores=new ArrayList<OnlineStore>();
	
	
	public OnlineStoreOwner (){
		this.username="";
		this.password="";
	}
	
	
	public  OnlineStoreOwner (String username,String password) throws IOException {
		this.username=username;
		this.password=password;
		registerOnlineSO(this.username,this.password);
	}
	
	
	
	
	public void Set_data(String username,String password) throws IOException {
		this.username=username;
		this.password=password;
		loginOnlineSO(this.username,this.password);
	}
	
	
	
	public void registerOnlineSO(String username,String password) throws IOException {
		register(username, password,4);
	}
	
	
	
	
	public void loginOnlineSO(String username,String password) throws IOException {
		login(username, password,4);
	}

	
	
	public void add_OnlineStore(OnlineStore s) throws IOException {
			String filename=this.username+".txt";
			this.stores.add(s);
			StoreOwnerFuncs.add_OnlineStore(s,filename);
		    
	}
	

	
	public boolean searchstores(OnlineStore s) throws IOException {
		String filename=this.username+".txt";
		if( StoreOwnerFuncs.search_Onlinestores(s, filename)==false) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	
	public void Add_OnlineStoreProducts(OnlineStore s) throws IOException {
		String filename=this.username+".txt";
		StoreOwnerFuncs.Add_OnlineProducts(s,filename);
	}
 
    
    
	public void Get_OnlineStoreOwnerProducts() throws IOException {
		String filename=this.username+".txt";
		StoreOwnerFuncs.get_OnlineStoreProducts(filename);
		
	}
	
	
	public void get_CustViewiStats() throws IOException {
		File c=new File("StoreViewCounter.txt");
		Scanner cn=new Scanner(c);
		int count=Integer.parseInt(cn.nextLine());
		System.out.println("The no. of customers that viewed store: "+ count);
	}
	
	
	public void get_CustBuyStats() throws IOException {
		File c=new File("CustomerUsername.txt");
		int counter=0;
		ArrayList<String>customers=new ArrayList <String>();
		Scanner sc=new Scanner(c);
		String name=null;
		while(sc.hasNextLine()) {
			name=sc.nextLine();
			customers.add(name);
		}
		for(int i=0; i<customers.size(); i++) {
			String filename=customers.get(i);
			filename=filename+".txt";
			File d=new File(filename);
			if(d.length()!=0) {
				counter++;
			}
			else {
				continue;
			}
		}
		
		System.out.println("The number of customers bought products: "+counter);
	}
	
	
	public void get_SoldOutStats() throws IOException {
		ArrayList <String> OnlineStores=new ArrayList<String>();
		int amount=0;
		String name;
		OnlineStores=Database.get_OnlineStoreNames();
		System.out.println("Products that were sold out: ");
		for(int i=0; i<OnlineStores.size(); i++) {
			String filename=OnlineStores.get(i)+".txt";
			File f=new File(filename);
			Scanner obj=new Scanner(f);
			while(obj.hasNextLine()) {
				name=obj.nextLine();
				obj.nextLine();
				obj.nextLine();
				obj.nextLine();
				obj.nextLine();
				obj.nextLine();
				obj.nextLine();
				amount=Integer.parseInt(obj.nextLine());
				if(amount==0) {
					System.out.println("ProductName: "+name);
				}
				else {
					continue;
				}
			}
		}
		
	}

	
	

}