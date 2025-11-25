package eventManager;

import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class UserAccount extends Account implements Serializable
{
	private static ArrayList<UserAccount> userList = new ArrayList<UserAccount>();
	
	
	public UserAccount(String name, String password, int id) 
	{
		super(name, password, id);
	}
	
	public void print()
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Name: " + this.getName());
		System.out.println("Password: " + this.getPassword());
		System.out.println("ID: " +this.getId());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	
	
	public static boolean verifyValidUsername(String name)
	{
		// Check if name is valid
		if (name.equals(""))
		{
			return false;
		}
		return true;
		// TODO develop method stub
	}
	
	public static boolean verifyValidPassword(String password)
	{
		if (password.equals(""))
		{
			return false;
		}
		return true;
	}
	
	// Make sure username isn't already taken
	// by scanning through user array
	
	// Returns true if theres a conflict
	public static boolean checkUsernameConflict(String name)
	{
		
		boolean uniqueName = true;
		
		for (UserAccount account : UserAccount.getUserList())
		{
			if(account.getName().equals(name))
			{
				uniqueName = false;
			}
			
		}
		
		return !uniqueName;
		
	}
	
	// Generate random number
	// then check the user array to ensure it isnt already taken
	// if it isnt return the int, otherwise try again
	public static int generateUniqueId()
	{
		while(true)
		{
			boolean uniqueId = true;
			int randomId = ThreadLocalRandom.current().nextInt(100000, 1000000);
			
			for (UserAccount account : userList)
			{
				if(account.getId() == randomId)
				{
					uniqueId = false;
				}
				
			}
			
			if (uniqueId)
			{
				return randomId;
			}
			
		}
	}
	
	// Adds a user to the user lists
	public void addUser()
	{
		deSerialiseUserArray();
		userList.add(this);
		saveUsers();
	}
	
	// Returns the user list
	public static ArrayList<UserAccount> getUserList()
	{
		
		deSerialiseUserArray();
		return userList;
	}
	
	public static void deleteUsers()
	{
		userList.clear();
		saveUsers();
	}
	// Serialize the user list
	private static void saveUsers()
	{
		// Serialize User object
		try
		{
			
			FileOutputStream fo = new FileOutputStream("users.ser");
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			
			oo.reset();
			
			oo.writeObject(userList);
			
			System.out.println("Objects Serialized");
			
			oo.close();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
	
	
	// De-serialises user list
	private static void deSerialiseUserArray()

	
	{
		try
		{

			// Deserialize user array
			System.out.println("Tring to deserialize");
			FileInputStream fi = new FileInputStream("users.ser");
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			ArrayList<UserAccount> newList = (ArrayList<UserAccount>)oi.readObject();
			
			
			userList = newList;
			
			oi.close();
			
			System.out.println("Objects Deserialized");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("No file, creating file");
			
			// Serialize User object
			try
			{
				saveUsers();
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
			}
		}
	}

	// Overiding equals method
	@Override
	public boolean equals(Object o)
	{
		if (o instanceof UserAccount)
		{
			UserAccount other = (UserAccount)o;
			
			return this.getId() == other.getId();
		}
		return false;
	}
}
