import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User{
	
	
	public Customer (){
		this.username="";
		this.password="";
	}
	
	
	public Customer (String username,String password) throws IOException {
		this.username=username;
		this.password=password;
		registerCust(this.username,this.password);
	}
	
	public void Set_data(String username,String password) throws IOException {
		this.username=username;
		this.password=password;
		loginCust(this.username,this.password);
	}
	
	
	public void registerCust(String username,String password) throws IOException {
		register(username,password,2);
	}
	
	
	public void loginCust(String username,String password) throws IOException {
		login(username,password,2);
	}
	

	
	public void buy_Products() throws IOException {
		Scanner n=new Scanner(System.in);
		int count=0;
		ArrayList <String> StoreNames=new ArrayList<String>();
		ArrayList<Products> StoreProducts=new ArrayList<Products>();
		System.out.println("Enter 1 if you want to view Online stores or 2 to view Onsite ones: ");
		int r=n.nextInt();
		if(r==1) {
			StoreNames=Database.get_OnlineStoreNames();
		}
		else if(r==2) {
			StoreNames=Database.get_OnsiteStoreNames();
		}
		System.out.println("Here is a list stores available.");
		for(int i=0; i<StoreNames.size(); i++) {
			System.out.println(StoreNames.get(i));
		}
		
		File c=new File("StoreViewCounter.txt");
		Scanner cn=new Scanner(c);
		count=Integer.parseInt(cn.nextLine());
		count++;
		FileWriter fileWriter= new FileWriter(c);
		BufferedWriter bw =new BufferedWriter(fileWriter);
		bw.write(String.valueOf(count));
		
		System.out.println("Please enter the store name you want to view products from: ");
		String storeName=n.next();
		String filename=storeName.concat(".txt");
		File f= new File(filename);
		Scanner obj= new Scanner(f);
		Scanner obj2= new Scanner(f);
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
			StoreProducts.add(p);	
	}
		System.out.println("Here is the list of products in this store: ");
		for(int i=0; i<StoreProducts.size(); i++) {
			System.out.println("ProductName: " + StoreProducts.get(i).get_name());
			System.out.println("Serial: " + StoreProducts.get(i).get_SerialNo());
			System.out.println("Category: " + StoreProducts.get(i).get_category());
			System.out.println("Type: " + StoreProducts.get(i).get_type());
			System.out.println("BrandName: " + StoreProducts.get(i).get_Brand().getBrandName());
			System.out.println("BrandCategory: " + StoreProducts.get(i).get_Brand().getBrandCategory());
			System.out.println("Price: " + StoreProducts.get(i).get_price());
			System.out.println("Amount: " + StoreProducts.get(i).get_amount());
		}
		
		System.out.println("Please enter the serial no. of the product you want to buy: ");
		int wantedserial=n.nextInt();
		int index=-1;
		Products p1=null;
		for(int i=0; i<StoreProducts.size(); i++) {
			if(wantedserial==StoreProducts.get(i).get_SerialNo()) {
				index=i;
				p1=StoreProducts.get(i);
			}
			else {
				continue;
			}
			
		}
		
		if(index==-1) {
			System.out.println("Wrong Serial Number.");
			System.out.println("Press 1 to enter a valid serial no. or 0 to exit: ");
			int x=n.nextInt();
			if(x==0) {
				System.exit(1);
			}
			else {
				buy_Products();
				return;
			}
		}
		
		else {
			System.out.println("Enter the amount you want of this product: ");
			int y=n.nextInt();
			if(y<=p1.get_amount()) {
				p1.set_amount(p1.get_amount()-y);
				System.out.println("Enter shipping address: ");
				String address=n.next();
				String fname=this.username+".txt";
				File k=new File(fname);
				FileWriter fileWriter2= new FileWriter(k,true);
				BufferedWriter bw2 =new BufferedWriter(fileWriter2);
				bw2.newLine();
				bw2.write(p1.get_name());
				bw2.newLine();
				bw2.write(String.valueOf(p1.get_SerialNo()));
				bw2.newLine();
				bw2.write(p1.get_category());
				bw2.newLine();
				bw2.write(p1.get_type());
				bw2.newLine();
				bw2.write(p1.get_Brand().getBrandName());
				bw2.newLine();
				bw2.write(p1.get_Brand().getBrandCategory());
				bw2.newLine();
				bw2.write(String.valueOf(p1.get_price()));
				bw2.newLine();
				bw2.write(String.valueOf(y));
				bw2.newLine();
				bw2.write(address);
				StoreProducts.get(index).set_amount(p1.get_amount());
				bw2.close();
				
				k=new File(filename);
				fileWriter2= new FileWriter(k);
				bw2 =new BufferedWriter(fileWriter2);
				for(int i=0; i<StoreProducts.size(); i++) {
					bw2.write(StoreProducts.get(i).get_name());
					bw2.newLine();
					bw2.write(String.valueOf(StoreProducts.get(i).get_SerialNo()));
					bw2.newLine();
					bw2.write(StoreProducts.get(i).get_category());
					bw2.newLine();
					bw2.write(StoreProducts.get(i).get_type());
					bw2.newLine();
					bw2.write(StoreProducts.get(i).get_Brand().getBrandName());
					bw2.newLine();
					bw2.write(StoreProducts.get(i).get_Brand().getBrandCategory());
					bw2.newLine();
					bw2.write(String.valueOf(StoreProducts.get(i).get_price()));
					bw2.newLine();
					bw2.write(String.valueOf(StoreProducts.get(i).get_amount()));
					bw2.newLine();
				}
				bw2.close();
			}
			else {
				System.out.println("Amount exceeds the stock value.");
				System.exit(1);
			}
			
			
		}

		System.out.println("Press 1 to buy another item or 0 to exit: ");
		int d=n.nextInt();
		if(d==1) {
			buy_Products();
		}
		else {
			System.exit(1);
		}
		
}
	
	
	
	}