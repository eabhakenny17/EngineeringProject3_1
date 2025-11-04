package eventManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LoginTest {

	// Test 1
	// Test verifyValidUsername for an invlaid login
	//name = "Test" password = "TestPassword"
	//Outcome: 0 returned
	@Test
	void attemptLogin001test() 
	{
		Login login = new Login();
		
		UserAccount.deleteUsers();
		assertEquals(0, login.attemptLogin("Test", "TestPassword"));
	}
	
	// Test 2
	// Test verifyValidUsername for a valid login
	//name = "Test" password = "TestPassword"
	//Outcome: 1 returned
	@Test
	void attemptLogin002test() 
	{
		Login login = new Login();
		
		UserAccount.deleteUsers();
		UserAccount newAccount = new UserAccount("Test", "TestPassword", 1);
		newAccount.addUser();
		
		assertEquals(1, login.attemptLogin("Test", "TestPassword"));
	}
	
	// Test 3
	// Test signInViaID for a valid login
	//name = "Test" password = "TestPassword"
	//Outcome: account named test returned
	@Test
	void signInViaID003test() 
	{
		Login login = new Login();
		
		UserAccount.deleteUsers();
		UserAccount newAccount = new UserAccount("Test", "TestPassword", 1);
		newAccount.addUser();
		
		UserAccount testUser = login.signInViaID(1);
		
		assertEquals(testUser, newAccount);
	}

}
