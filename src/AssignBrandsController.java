import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AssignBrandsController implements I_SystemMessages, I_UserInputs,I_BrandValidation{
	
	private String name="";
	
	public AssignBrandsController() {
		this.name="";
	}
	
	
	public ArrayList<Brands> getList() throws IOException {
		Brands b=new Brands();
		ArrayList<Brands> list=new ArrayList <Brands>();
		list=b.get_Brands();
		return list;
	}
	
	
	@Override
	public void messages() {
		ArrayList<Brands> list=new ArrayList <Brands>();
		try {
			list=getList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Here is the list of brands. Enter the brand name you want to assign your product to: ");
		for(int j=0; j<list.size(); j++) {
			System.out.print("BrandName: ");
			System.out.println(list.get(j).getBrandName());
			System.out.print("BrandCategory: ");
			System.out.println(list.get(j).getBrandCategory());
		}	
	}
	
	@Override
	public void getUserInputs() throws IOException {
		Scanner n=new Scanner(System.in);
		this.name=n.next();
	}
	

	@Override
	public Brands ValidateChosenBrand() throws IOException {
		getUserInputs();
		ArrayList<Brands> list=new ArrayList <Brands>();
		Brands m=new Brands();
		try {
			list=getList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int j=0; j<list.size(); j++) {
			if(this.name.equals(list.get(j).getBrandName())) {
				m=new Brands(this.name,list.get(j).getBrandCategory());
				return m;
			}
			else {
				continue;
			}
		}
		return null;
	}



	
}
