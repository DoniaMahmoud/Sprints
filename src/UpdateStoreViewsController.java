import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UpdateStoreViewsController extends UpdateStats{
	private String storename;
	
	public UpdateStoreViewsController(String s) {
		this.storename=s;
	}	
	
	public String GenerateFilePath() {
		String filename=this.storename+"Viewer.txt";
		return filename;
	}
	
	
	

}
