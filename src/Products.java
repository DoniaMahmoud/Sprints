import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Products extends Database{
	private String ProductName;
	private int SerialNo;
	private String category;
	private String type;
	private Brands brand;
	private int price;
	private int amount;
	public static ArrayList <Products> listNormalProducts=new ArrayList <Products>();
	public static ArrayList <Products> listOnlineProducts=new ArrayList <Products>();
	
	
	
	 public Products() throws IOException {
	    	this.ProductName="";
	    	//this.SerialNo=this.Generate_SerialNo();
	    	this.category="";
	    	this.type="";
	    	this.price=0;
	    	this.amount=0;
	    }

	 
	
    public Products(String ProductName,String category ,String type,int price) throws IOException {
    	this.ProductName=ProductName;
    	//this.SerialNo=this.Generate_SerialNo();
    	this.category=category;
    	this.type=type;
    	this.price=price;
    	//this.amount=0;//not sure
    	
    }
    
   
    
    public Products(String ProductName,int serial,String category ,String type,int price) throws IOException {
    	this.ProductName=ProductName;
    	this.SerialNo=serial;
    	this.category=category;
    	this.type=type;
    	this.price=price;
    	this.amount=0;	
    }
    
    
    
    public Products(String ProductName,int serialNo,String category ,String type,Brands brand,int price,int amount) {
    	this.ProductName=ProductName;
    	this.SerialNo=serialNo;
    	this.category=category;
    	this.type=type;
    	this.brand=brand;
    	this.price=price;
    	this.amount=amount;
    }
    
    
    
    public int Generate_SerialNo() throws IOException { 
    	ArrayList<Products>products=new ArrayList<Products>();
    	if(this.type.equals("normal")) {
    		products=get_NormalProducts();
    		this.SerialNo=products.size()+1;
    	}
    	else {
    		products=get_OnlineProducts();
    		this.SerialNo=5000+products.size()+1;
    	}
    	
    	return this.SerialNo;
    }
    
    
    
    public void set(String ProductName,String category ,String type,int price) {
    	this.ProductName=ProductName;
    	this.category=category;
    	this.type=type;
    	this.price=price;
    }
    
    
    
    public void set_name(String ProductName) {
    	this.ProductName=ProductName;
    }
    
    
    public void set_category(String category) {
    	this.category=category;
    }
    
    
    public void set_price(int price) {
    	this.price=price;
    }
    
    
    public void set_type(String type) {
    	this.type=type;
    }
    
    
    public void set_brands(Brands b) {
    	this.brand=b;
    }
   
    
    public void set_amount(int amount) {
    	this.amount=amount;
    }
    
    
    public void set_serial(int serial) {
    	this.SerialNo=serial;
    }
    
    
    public String get_name() {
    	return this.ProductName;
    }
    
    
    public String get_category() {
    	return this.category;
    }
    
    
    public int get_price() {
    	return this.price;
    }
    
    
    public Brands get_Brand() {
    	return this.brand;
    }
    
    
    public String get_type() {
    	return this.type;
    }
    
    
    public int get_SerialNo() {
    	return this.SerialNo;
    }
    
    
    public int get_amount() {
    	return this.amount;
    }
    
    
	public static void setNormalProducts() throws IOException {	
		String filename=NormalProductsList;
		I_ReadProdsFromFiles r=new ReadSystemProdsController();
		listNormalProducts=r.readProds(filename);
	}
	
	
	public static void setOnlineProducts() throws IOException {	
		String filename=OnlineProductsList;
		I_ReadProdsFromFiles r=new ReadSystemProdsController();
		listOnlineProducts=r.readProds(filename);
	}
	
	
	public static ArrayList<Products> get_NormalProducts() throws IOException{
		setNormalProducts();
		return listNormalProducts;
	}
	
	
	public static ArrayList<Products> get_OnlineProducts() throws IOException{
		setOnlineProducts();
		return listOnlineProducts;
	}
	
	
	public static ArrayList<Products> get_AllProducts() throws IOException{
		ArrayList<Products> AllProducts=new ArrayList<Products>();
		get_NormalProducts();
		get_OnlineProducts();
		for(int i=0; i<listNormalProducts.size(); i++) {
			AllProducts.add(listNormalProducts.get(i));
		}
		for(int i=0; i<listOnlineProducts.size(); i++) {
			AllProducts.add(listOnlineProducts.get(i));
		}
		return AllProducts;
		}
	
	
	
	
	
	/*
	public void printComp(Products p) {
		//p=new Products();
		System.out.println(p.ProductName);
		System.out.println(p.category);
		System.out.println(p.price);
	}
	
*/
	
}