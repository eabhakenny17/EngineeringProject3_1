package eventManager;

import java.util.ArrayList;

public class Login 
{
	// If login is valid returns the id, otherwise returns 0
	public int attemptLogin(String name, String password)
	{
		ArrayList<UserAccount> userList = UserAccount.getUserList();
		
		for (UserAccount item : userList)
		{
			if (item.getName().equals(name) && item.getPassword().equals(password))
			{
				return item.getId();
			}
		}
		
		return 0;
	}
	
	// Returns the UserAccount attached to the id
	public UserAccount signInViaID(int id)
	{
		ArrayList<UserAccount> userList = UserAccount.getUserList();
		
		for (UserAccount item : userList)
		{
			if (id == item.getId())
			{
				return item;
			}
		}
		return null;
	}
}
