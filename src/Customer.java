import java.io.IOException;

public class Customer extends User{
	
	public Customer (){
		this.username="";
		this.password="";
	}
	
	
	public Customer (String username,String password) throws IOException {
		this.username=username;
		this.password=password;
	}
	
	public void Set_data(String username,String password) {
		this.username=username;
		this.password=password;
	}
	
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	
	public void BuyProduct(Products p,String address) throws IOException {
		String filename=this.username+".txt";
		I_WriteProdsToFiles w=new WriteProdsToStoresController();
		w.WriteProducts(filename, p);
		I_WriteToFiles f=new WriteRegData();
		f.writeData(address,filename);
	}
	
	
	/*
	
	public void registerCust(String username,String password) throws IOException {
		register(username,password,2);
	}
	
	
	public void loginCust(String username,String password) throws IOException {
		login(username,password,2);
	}
	

*/
}
