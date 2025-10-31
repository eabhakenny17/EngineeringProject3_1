package eventManager;

import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class UserAccount extends Account implements Serializable
{
	private static ArrayList<UserAccount> userList;
	
	
	public UserAccount(String name, String password, int id) 
	{
		super(name, password, id);

	}
	
	public void print()
	{
		System.out.println("Name: " + this.getName());
		System.out.println("Password: " + this.getPassword());
		System.out.println("ID: " +this.getId());
	}
	
	public static boolean verifyValidPassword(String password)
	{
		return false;
		// TODO develop method stub
	}
	
	// Make sure username isn't already taken
	// by scanning through user array
	
	// Returns true if theres a conflict
	public static boolean checkUsernameConflict(String name)
	{
		
		boolean uniqueName = true;
		
		for (UserAccount account : userList)
		{
			if(account.getName().equals(name))
			{
				uniqueName = false;
			}
			
		}
		
		if (uniqueName)
		{
			return true;
		}
		return false;
		
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
	public static void addUser(UserAccount account)
	{
		userList.add(account);
	}
	
	// Serialize the user list
	public static void saveUsers()
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
	
	// Returns the user list
	public static ArrayList<UserAccount> getUserList()
	{
		
		deSerialiseUserArray();
		return userList;
	}
	
	private static void deSerialiseUserArray()
	{
		try
		{

			// Deserialize user array
			System.out.println("Tring to deserialize");
			FileInputStream fi = new FileInputStream("users.ser");
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			System.out.println("Objects Deserialized");
			
			ArrayList<UserAccount> newList = (ArrayList<UserAccount>)oi.readObject();
			
			userList = newList;
			
			oi.close();
		}
		
		catch(Exception e)
		{
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
	
}
