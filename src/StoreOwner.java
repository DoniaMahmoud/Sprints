import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreOwner extends User {
	private ArrayList<Stores> stores=new ArrayList<Stores>();
	private static String type;
	
	
	public StoreOwner (){
		this.username="";
		this.password="";
	}
	
	
	public StoreOwner (String username,String password,String type) throws IOException {
		this.username=username;
		this.password=password;
	    this.type=type;
		
	}
	

	public StoreOwner (String username,String password) throws IOException {
		this.username=username;
		this.password=password;
	}
	
	
	public void set_typeFromUser() {
		I_SystemMessages s=new StoreOwnerType();
		s.messages();
		I_ReturnStringChoices r=new StoreOwnerType();
		this.type=r.Get_choice();
	}
	
	public  void Settype(String t) {
		this.type=t;
	}
	
	
	public void Set_data(String username,String password) {
		this.username=username;
		this.password=password;
		set_typeFromUser();
	}
	
	public void SetData(String username,String password,String type) {
		this.username=username;
		this.password=password;
		this.type=type;
	}
	
	
	public static String get_type() {
		return type;
	}
	
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void addStore(Stores s) throws IOException {
		String filename=this.username+".txt";
		this.stores.add(s);
		if(this.get_type().equals("online")) {
			if(Adminstrator.approveOnlineStore()) {
				create_StorePath(this,s);
				I_WriteStores w=new WriteOnlineStores();
				w.writeStores(s, filename);
			}
		}
		else {
			create_StorePath(this,s);
			I_WriteStores w=new WriteOnsiteStores();
			w.writeStores(s, filename);
		}
	
	}
	
	
	public void AddProductsToStore(Products p,String name) throws IOException {
		String filename=name+".txt";
		I_WriteProdsToFiles t=new WriteProdsToStoresController();
		t.WriteProducts(filename, p);
	}
	
	
	public void PrintStats(int value) throws IOException {
		System.out.println(value);
	}


	public void PrinttSoldout(ArrayList<String> s) {
		for(int i=0; i<s.size(); i++) {
			System.out.println(s.get(i));
		}
	}
	
	
	
	
}
