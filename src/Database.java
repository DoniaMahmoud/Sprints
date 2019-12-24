import java.io.BufferedWriter;
import java.io.File;
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
	protected static String UserStats ="UserStats.txt";
	
	
	 public void create_UserPath(String username) throws IOException{
			String path="";
			path=path.concat(username);
			path=path.concat(".txt");
			File file = new File(path);
			file.createNewFile();
			
	}
	 
	 
	 public static void create_StorePath(StoreOwner o,Stores s) throws IOException {
		 String path="";
		 path=path.concat(s.getStore_Name());
		  path=path.concat(".txt");
		  File file = new File(path);
			if(file.createNewFile()) {
				System.out.println("Store Added Successfully");
			}
			else {
				System.out.println("Store name is taken. Try a different one: ");
				I_SystemMessages m=new NewStoreController();
				m.messages();
				I_UserInputs i=new NewStoreController(o);
				i.getUserInputs();
			}
			
			create_StoreProdsStatsPath(s.getStore_Name());
			create_StoreSoldOutStatsPath(s.getStore_Name());
	 }
	 
	 
	 public static void create_StoreProdsStatsPath(String name) throws IOException{
		  String path="";
		  path=path.concat(name);
		  path=path.concat("ProdsStats.txt");
		  File file = new File(path);
		  file.createNewFile();		
	 }
	 
	 
	 public static void create_StoreSoldOutStatsPath(String name) throws IOException{
		  String path="";
		  path=path.concat(name);
		  path=path.concat("SoldOutStats.txt");
		  File file = new File(path);
		  file.createNewFile();		
	 }
	 
	 
	 public static void create_StoreViewerPath(String storename) throws IOException {
		 String path="";
		 path=path.concat(storename);
		 path=path.concat("Viewer");
		 path=path.concat(".txt");
		 File file=new File(path);
		 if(file.createNewFile()) {
			 FileWriter fileWriter2= new FileWriter(file,true);
			 BufferedWriter bw2 =new BufferedWriter(fileWriter2);
			 bw2.write("0");
			 bw2.close();
		 }
		 else {
			 return;
		 }
	 }
	 
	 
	 
	 public static void create_StoreBuyingStatsPath(String storename) throws IOException {
		 String path="";
		 path=path.concat(storename);
		 path=path.concat("BuyingStats");
		 path=path.concat(".txt");
		 File file=new File(path);
		 if(file.createNewFile()) {
			 FileWriter fileWriter2= new FileWriter(file,true);
			 BufferedWriter bw2 =new BufferedWriter(fileWriter2);
			 bw2.write("0");
			 bw2.close();
		 }
		 else {
			 return;
		 }
	 }
	 
	 
	 
	 
	 public static boolean searchstores(StoreOwner s,String Storename) throws IOException{
		 String filename=s.getUsername()+".txt";
		 ArrayList <String>written=new ArrayList<String>();
		 I_ReadFromFiles r=new ReadDataController();
		 written=r.readFile(filename);
		 for(int i=0; i<written.size(); i++) {
			 if(written.get(i).equals(Storename)) {
				 return true;
			 }
			 else {
				 continue;
			 }
		 }
		return false; 
	 }
	 
	 
	 
	 
	 
}
