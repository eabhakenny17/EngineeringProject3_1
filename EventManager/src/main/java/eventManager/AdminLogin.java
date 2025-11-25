package eventManager;

import java.util.ArrayList;

public class AdminLogin 
{
	// If login is valid returns the id, otherwise returns 0
	public static int attemptLogin(String name, String password)
	{
		AllAdminAccounts adminList = new AllAdminAccounts();
		ArrayList<AdminAccount> admins = adminList.getAdminAccountsList();
		
		for (AdminAccount a : admins)
		{
			if (a.getName().equals(name) && a.getPassword().equals(password))
			{
				return a.getAId();
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
