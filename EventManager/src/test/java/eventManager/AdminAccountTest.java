package eventManager;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdminAccountTest 
{

	// Test 1
	// Test attemptLogin for a blank name and password
	//name = "", password = ""
	//Outcome: false returned
	@Test
	void attemptLogin001test() 
	{
		assertEquals(0, AdminLogin.attemptLogin("", ""));
	}
	
	// Test 2
	// Test attemptLogin for an unauthorized name
	//name = "Tim"
	//Outcome: false returned
	@Test
	void attemptLogin002test() 
	{
		assertEquals(0, AdminLogin.attemptLogin("Tim", "password"));
	}
	
	// Test 3
	// Test attemptLogin for an incorrect password
	//name = "Eabha", password = "incorrect"
	//Outcome: false returned
	@Test
	void attemptLogin003test() 
	{
		assertEquals(0, AdminLogin.attemptLogin("Eabha", "incorrect"));
	}
	
	// Test 4
	// Test attemptLogin for a valid login
	//name = "Eabha", password = "password"
	//Outcome: true returned
	@Test
	void verifyValidPassword004test() 
	{
		assertEquals(0, AdminLogin.attemptLogin("Eabha", "password"));
	}
}