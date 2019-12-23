import java.io.IOException;
import java.util.ArrayList;

public abstract class Subject {

	protected ArrayList<Observer> observers=new ArrayList<Observer>();
	
	public abstract void registerObserver(Observer o);
	public abstract void removeObserver(Observer o);
	public abstract void notifyObserver() throws IOException;
	public abstract void DataChanged() throws IOException;
	
}
