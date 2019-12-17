import java.util.Scanner;

public class StoreOwnerType implements I_SystemMessages , I_UserInputs, I_ReturnStringChoices {
	private String type;
	
	public void set_Type(String c) {
		this.type=c;
	}
	
	@Override
	public void messages() {
		System.out.println("Enter whether you are onsite or online storeOwner:");	
	}

	
	@Override
	public void getUserInputs() {
		Scanner s=new Scanner(System.in);
		set_Type(s.next());
	}

	
	@Override
	public String Get_choice() {
		getUserInputs();
		return this.type;
	}


}
