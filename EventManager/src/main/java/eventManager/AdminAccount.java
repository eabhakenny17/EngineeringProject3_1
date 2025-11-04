package eventManager;
//REGULAR USER ACCOUNT
import java.io.Serializable;

public abstract class AdminAccount implements Serializable
{
	
	private String Aname;
	private String Apassword;
	private int Aid;
	
	
	public AdminAccount(String name, String password, int id) 
	{
		this.Aname = name;
		this.Apassword = password;
		this.Aid = id;	
		
	}

	public String getName() {
		return Aname;
	}

	public void setName(String name) {
		this.Aname = name;
	}

	public String getPassword() {
		return Apassword;
	}

	public void setPassword(String password) {
		this.Apassword = password;
	}

	public int getId() {
		return Aid;
	}

	public void setId(int id) {
		this.Aid = id;
	}
	
	
}
