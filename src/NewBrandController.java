import java.io.IOException;
import java.util.Scanner;

public class NewBrandController implements I_SystemMessages, I_UserInputs {

    private Adminstrator admin=new Adminstrator();
	
	public NewBrandController(Adminstrator a) {
		this.admin=a;
	}

	@Override
	public void messages() {
		System.out.println("Enter BrandName and BrandCategory: ");
	}

	
	@Override
	public void getUserInputs() throws IOException {
		Scanner r = new Scanner(System.in);
		String name=r.next();
	    String category=r.next();
	    Brands b=new Brands(name,category);
	    sendBrandData(b);
	}
	
	public void sendBrandData(Brands b) throws IOException {
		this.admin.addNewBrand(b);
	}


}
