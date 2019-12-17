import java.io.IOException;
import java.util.Scanner;

public class NewProductController implements I_SystemMessages, I_UserInputs{

	private Adminstrator admin=new Adminstrator();
	
	public NewProductController() {
		this.admin=null;
	}

	
	public NewProductController(Adminstrator a) {
		this.admin=a;
	}

	
	@Override
	public void messages() {
		System.out.println("Enter ProductName, ProductCategory, ProductType and ProductPrice: ");
	}


	@Override
	public void getUserInputs() throws IOException {
		Scanner s=new Scanner(System.in);
		String Name=s.next();
		String Category=s.next();
		String Type=s.next();
		int Price=s.nextInt();
		Products p=new Products(Name,Category,Type,Price);
		sendProdData(p);
		
	}
	
	public void sendProdData(Products p) throws IOException {
		int serial=p.Generate_SerialNo();
		p.set_serial(serial);
		this.admin.addNewProduct(p);
	}


	
}
