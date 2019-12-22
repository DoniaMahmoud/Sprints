import java.io.IOException;
import java.util.Scanner;

public class CustomerAmountChoiceController implements I_SystemMessages , I_UserInputs, I_ReturnIntChoices{
	
	private Customer c=new Customer();
	private  Products product;
	private int choiceAmount;
	
	public CustomerAmountChoiceController() {
		this.product=null;
		this.c=null;
	}
	
	public CustomerAmountChoiceController(Products p) {
		this.product=p;
	}
	
	public CustomerAmountChoiceController(Products p,Customer c) {
		this.product=p;
		this.c=c;
	}
	
	public void set_choice(int c) {
		this.choiceAmount=c;
	}
	
	
	@Override
	public void messages() {
		System.out.println("Enter the amount you want of this product: ");	
	}
	
	@Override
	public void getUserInputs() throws IOException {
		Scanner s=new Scanner(System.in);  
		set_choice(s.nextInt());
		CheckAmount();
	}

	public void CheckAmount() throws IOException {
		if(this.choiceAmount>this.product.get_amount() || this.product.get_amount()==0) {
			System.out.println("Amount exceeds the stock value.");
			System.exit(1);
		}
		else {
			this.product.set_amount(this.choiceAmount);
			SendToPurchase(this.product);
		}
	}
	
	public void SendToPurchase(Products p) throws IOException {
		this.c.BuyProduct(p);
		}

	@Override
	public int get_choice() {
		try {
			getUserInputs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.choiceAmount;
	}
	

	
}
