import java.io.IOException;

public interface I_EntryValidation {

	public boolean registerValidate(String username,String usernamefile) throws IOException;
	public boolean loginValidate(String username,String usernamefile,String password,String passwordfile) throws IOException;
}
