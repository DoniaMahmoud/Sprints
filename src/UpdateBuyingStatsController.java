import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UpdateBuyingStatsController extends UpdateStats{
	
	public UpdateBuyingStatsController(String s,Subject sub) {
		this.sub=sub;
		sub.registerObserver(this);
		this.storename=s;
	}
	
	
	public UpdateBuyingStatsController(String s) {
		this.storename=s;
	}
	
	
	public String GenerateFilePath() {
		String filename=this.storename+"BuyingStats.txt";
		return filename;
	}
	
	
	
	

}


