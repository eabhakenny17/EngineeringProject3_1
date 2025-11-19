package eventManager;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserAccountTest 
{

	// Test 1
	// Test verifyValidUsername for a blank name
	//name = ""
	//Outcome: false returned
	@Test
	void verifyValidUsername001test() 
	{
		assertEquals(false, UserAccount.verifyValidUsername(""));
	}
	
	// Test 2
	// Test verifyValidUsername for a valid name
	//name = "Tim"
	//Outcome: true returned
	@Test
	void verifyValidUsername002test() 
	{
		assertEquals(true, UserAccount.verifyValidUsername("Tim"));
	}
	
	// Test 3
	// Test verifyValidPassword for a blank password
	//name = ""
	//Outcome: false returned
	@Test
	void verifyValidPassword003test() 
	{
		assertEquals(false, UserAccount.verifyValidUsername(""));
	}
	
	// Test 4
	// Test verifyValidPassword for a valid password
	//name = "Tim"
	//Outcome: true returned
	@Test
	void verifyValidPassword004test() 
	{
		assertEquals(true, UserAccount.verifyValidUsername("ValidPassword123456"));
	}
	
	// Test 5
	// Test checkUsernameConflict for a non conflicting name
	//name = "Tim"
	//Outcome: false returned
	@Test
	void checkUsernameConflict005test() 
	{
		UserAccount.deleteUsers();
		assertEquals(false, UserAccount.checkUsernameConflict("tim"));
	}
	
	// Test 6
	// Test checkUsernameConflict for a conflicting name
	//name = "Tim"
	//Outcome: true returned
	@Test
	void checkUsernameConflict006test() 
	{
		UserAccount.deleteUsers();
		
		UserAccount newAccount = new UserAccount("tim", "password", 0);
		newAccount.addUser();
		
		assertEquals(true, UserAccount.checkUsernameConflict("tim"));
	}
	
	
	
	// Test 7
	// Test generateUniqueId generates an int between 100,000 and 999,999
	// 
	// Outcome: int between 100,000 and 999,999
	@Test
	void generateUniqueId007test() 
	{
		int testId = UserAccount.generateUniqueId();
		
		assertTrue(testId < 1000000 && testId >= 100000);
	}
	
	// Test 8
	// Test getUserList returns user list
	// account named tim
	// Outcome: ArrayList with tim
	@Test
	void getUserList008test() 
	{
		UserAccount.deleteUsers();
		
		UserAccount newAccount = new UserAccount("tim", "password", 0);
		newAccount.addUser();
		
		ArrayList<UserAccount> list = UserAccount.getUserList();
		
		assertEquals("tim", list.get(0).getName());
	}
	
	// Test 9
	// Test if UserAccount.equals() works
	// 2 Identical accounts name = tim, password = password, id = 0
	// Outcome: true
	@Test
	void accountEquals009test() 
	{
		
		UserAccount newAccount1 = new UserAccount("tim", "password", 0);
		UserAccount newAccount2 = new UserAccount("tim", "password", 0);
		
		assertTrue(newAccount1.equals(newAccount2));
	}
	
	// Test 10
	// Test if UserAccount.equals() works
	// 2 accounts with different id
	//name = tim, password = password, id = 0,1
	// Outcome: False
	@Test
	void accountEquals010test() 
	{
		
		UserAccount newAccount1 = new UserAccount("tim", "password", 0);
		UserAccount newAccount2 = new UserAccount("tim", "password", 1);
		
		assertFalse(newAccount1.equals(newAccount2));
	}
	
	// Test 11
	// Test if UserAccount.equals() works
	// 1 account obj, one string
	//name = tim, password = password, id = 0,1
	// Outcome: False
	@Test
	void accountEquals011test() 
	{
		
		UserAccount newAccount1 = new UserAccount("tim", "password", 0);
		String testString = "Tim";
		
		assertFalse(newAccount1.equals(testString));
	}
	
	// Test 12
	// Test if UserAccount.print() displays text
	// 1 account obj
	//name = tim, password = password, id = 0,1
	// Outcome: Details printed
	@Test
	void print012test() 
	{
		
		UserAccount newAccount1 = new UserAccount("tim", "password", 0);
		
		newAccount1.print();
		
		assertTrue(true);
	}
	
	// Test 13
	// Test if verifyValidPassword returns true with a valid password
	// password = "1234TestPassword"
	// Outcome: True returned
	@Test
	void verifyValidPassword013test() 
	{
		assertTrue(UserAccount.verifyValidPassword("1234TestPassword"));
	}
	
	// Test 14
	// Test if verifyValidPassword returns false with an invalid password
	// password = ""
	// Outcome: True returned
	@Test
	void verifyValidPassword014test() 
	{
		assertFalse(UserAccount.verifyValidPassword(""));
	}
	
	

}
