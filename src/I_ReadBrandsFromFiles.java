import java.io.IOException;
import java.util.ArrayList;

public interface I_ReadBrandsFromFiles {

	public ArrayList<Brands> readBrands(String filename) throws IOException;
}
