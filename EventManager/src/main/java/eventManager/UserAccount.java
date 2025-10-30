package eventManager;

public class UserAccount extends Account
{

	public UserAccount(String name, String password, int id) 
	{
		super(name, password, id);

	}
	
	public void print()
	{
		System.out.println("Name: " + this.getName());
		System.out.println("Password" + this.getPassword());
		System.out.println("ID: " +this.getId());
	}
	
}
