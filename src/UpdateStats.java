import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public abstract class UpdateStats {

	private String storename;
	
	public abstract String GenerateFilePath();
	public void updateCounter() throws IOException{
		String filename=GenerateFilePath();
		int counter=getCount();
		counter++;
		File f1 = new File(filename);
		FileWriter fileWriter1= new FileWriter(f1,false);
		BufferedWriter bw1 =new BufferedWriter(fileWriter1);
		bw1.write(String.valueOf(counter));
		bw1.close();
	}
	
	public int getCount() throws IOException {
		String filename=GenerateFilePath();
		File f=new File(filename);
		Scanner obj=new Scanner(f);
		String count="";
		while(obj.hasNextLine()) {
			count=obj.nextLine();
		}
		int counter=Integer.parseInt(count);
		return counter;
		}
	
	
}
