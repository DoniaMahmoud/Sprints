import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreOwner extends User{
	//private ArrayList<String> products= new ArrayList<String>();
	private ArrayList<OnsiteStore> stores=new ArrayList<OnsiteStore>();
	
	
	
	public StoreOwner (){
		this.username="";
		this.password="";
	}
	
	
	public StoreOwner (String username,String password) throws IOException {
		this.username=username;
		this.password=password;
		registerNormalSO(this.username,this.password);
	}
	
	
	
	
	public void Set_data(String username,String password) throws IOException {
		this.username=username;
		this.password=password;
		loginNormalSO(this.username,this.password);
	}
	
	
	
	public void registerNormalSO(String username,String password) throws IOException {
		register(username,password,3);
	}
	
	
	
	public void loginNormalSO(String username,String password) throws IOException {
		login(username,password,3);
	}
	

	
	
	public void add_Normalstore(OnsiteStore s) throws IOException {
		String filename=this.username+".txt";
		this.stores.add(s);
		StoreOwnerFuncs.add_OnsiteStore(s,filename);
	}
	
	
	
	public boolean searchstores(OnsiteStore s) throws IOException {
		String filename=this.username+".txt";
		if( StoreOwnerFuncs.search_Onsitestores(s,filename)==false) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	
	public void Add_NormalStoreProducts(OnsiteStore s) throws IOException{
		String filename=this.username+".txt";
		StoreOwnerFuncs.Add_OnsiteProducts(s,filename);
	}
	
	
	
	public void Get_NormalStoreOwnerProducts() throws IOException {
		String filename=this.username+".txt";
		StoreOwnerFuncs.get_OnsiteStoreProducts(filename);

		
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
			ArrayList <String> OnsiteStores=new ArrayList<String>();
			int amount=0;
			String name;
			OnsiteStores=Database.get_OnsiteStoreNames();
			System.out.println("Products that were sold out: ");
			for(int i=0; i<OnsiteStores.size(); i++) {
				String filename=OnsiteStores.get(i)+".txt";
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


/*	
	public void add_store(OnsiteStore r) {
		System.
	}
	*/	
}