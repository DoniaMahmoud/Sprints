import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Products {
	private String ProductName;
	private int SerialNo;
	private String category;
	private String type;
	private Brands brand;
	private int price;
	private int amount;
	public static ArrayList <Products> listNormalProducts=new ArrayList <Products>();
	public static ArrayList <Products> listOnlineProducts=new ArrayList <Products>();
    //public static String ProductsList = "D:\\1st TERM Year(3)\\Software Eng2\\Project\\ProductsList.txt";
	
	
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
    	this.amount=0;
    	
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
    	if(this.type.equals("normal")) {
    		File f= new File("C:\\Users\\Youss\\Desktop\\Sprints\\NormalProductsList.txt");
    		Scanner s=new Scanner(f);
    		int v=0;
    		while(s.hasNextLine()) {
    			v++;
    			s.nextLine();
    		}
    		v=v/5;
    		this.SerialNo=v+1;
    	}
    	else {
    		File f= new File("C:\\Users\\Youss\\Desktop\\Sprints\\OnlineProductsList.txt");
    		Scanner s=new Scanner(f);
    		int v=0;
    		while(s.hasNextLine()) {
    			v++;
    			s.nextLine();
    		}
    		v=v/5;
    		this.SerialNo=5000+v+1;
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
    	//this.brand.setBrandName(b.getBrandName());
    	//this.brand.setBrandCategory(b.getBrandCategory());
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
    
    
	public void setNormalProducts(ArrayList<Products> p) throws IOException {	
		listNormalProducts=p;
			
	}
	
	public void setOnlineProducts(ArrayList<Products> p) throws IOException {	
		listOnlineProducts=p;
			
	}
	
	
	
	public void printComp(Products p) {
		//p=new Products();
		System.out.println(p.ProductName);
		System.out.println(p.category);
		System.out.println(p.price);
	}
	

	public ArrayList<Products> get_AllProducts() throws IOException{
		ArrayList<Products> AllProducts=new ArrayList<Products>();
		Database d=new Database();
		d.Get_NormalProducts();
		d.Get_OnlineProducts();
		for(int i=0; i<listNormalProducts.size(); i++) {
			AllProducts.add(listNormalProducts.get(i));
		}
		for(int i=0; i<listOnlineProducts.size(); i++) {
			AllProducts.add(listOnlineProducts.get(i));
		}
		
		return AllProducts;
		
	}
	
	
	public ArrayList<Products> get_NormalProducts(){
		return listNormalProducts;
	}
	
	
	public ArrayList<Products> get_OnlineProducts(){
		return listOnlineProducts;
	}
	
	
}