import java.io.IOException;
import java.util.ArrayList;

public interface I_ReadProdsFromFiles {

	public ArrayList<Products> readProds(String filename) throws IOException;
}
