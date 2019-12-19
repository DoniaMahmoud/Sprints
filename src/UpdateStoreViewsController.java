import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UpdateStoreViewsController {
	private String storename;
	
	public UpdateStoreViewsController(String s) {
		this.storename=s;
	}
	
	public int getCount() throws IOException {
		String filename=this.storename+"Viewer.txt";
		File f=new File(filename);
		Scanner obj=new Scanner(f);
		String count="";
		while(obj.hasNextLine()) {
			count=obj.nextLine();
		}
		int counter=Integer.parseInt(count);
		return counter;
		}
	
	
	
	
	public void updateCounter() throws IOException {
		int counter=getCount();
		counter++;
		String filename=this.storename+"Viewer.txt";
		File f1 = new File(filename);
		FileWriter fileWriter1= new FileWriter(f1,false);
		BufferedWriter bw1 =new BufferedWriter(fileWriter1);
		bw1.write(String.valueOf(counter));
		bw1.close();
	}
	
	
	

}
