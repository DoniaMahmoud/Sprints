import java.io.IOException;

public class SoldOutStatsSubject extends Subject{
	@Override
	public void registerObserver(Observer o) {
		this.observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		   int i = this.observers.indexOf(o);
	        if (i >= 0) {
	            this.observers.remove(i);
	        }	
	}

	@Override
	public void notifyObserver() throws IOException {
	      for (int i = 0; i < this.observers.size(); i++) {
	            Observer observer = (Observer)observers.get(i);
	            observer.update();
	        }
	      
	}

	@Override
	public void DataChanged() throws IOException {
		notifyObserver();	
	}

}
