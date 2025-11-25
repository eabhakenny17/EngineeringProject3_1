package eventManager;

public class EventTest {
	void getEventNameTest001() {
		//test 001
		//test to get event name
		//event name = "Birthday Party"
		//outcome: correctly returns event name
		assertEquals("Birthday Party", "Birthday Party");
	}
	
	void getEventNameTest002() {
		//test 002
		//test to not get event name
		//event name = ""
		//outcome: does not return a name
		assertEquals("", "");
	}
	
	void setEventNameTest001() {
		//test 003
		//test to set event name
		//event name = "Birthday Party"
		//outcome: sets event name as "Birthday Party"
		assertEquals("Birthday Party");
	}
	
	void getEventVenueTest001() {
		//test 004
		//test to get event venue
		//event name = "X207"
		//outcome: correctly returns event venue
		assertEquals("X207", "X207");
	}
	
	void getEventVenueTest002() {
		//test 005
		//test to not get event venue
		//event name = ""
		//outcome: does not return a venue
		assertEquals("", "");
	}
	
	void setEventVenueTest001() {
		//test 006
		//test to set event venue
		//event name = "X207"
		//outcome: sets event name as "X207"
		assertEquals("X207");
	}
	
	void getEventMaxAttTest001() {
		//test 007
		//test to get max attendance
		//max attendance = 50
		//outcome: correctly returns max attendance
		assertEquals(50, 50);
	}
	
	void getEventMaxAttTest002() {
		//test 008
		//test to not get max attendance
		//max attendance = 
		//outcome: does not return max attendance
		assertEquals(,);
	}
	
	void setEventMaxAttTest001() {
		//test 009
		//test to set max attendance
		//max attendance = 50
		//outcome: sets max attendance at 50
		assertEquals("X207");
	}

	void getEventAttTest001() {
		//test 010
		//test to get attendance
		//attendance = 47
		//outcome: correctly returns attendance
		assertEquals(47, 47);
	}
	
	void getEventAttTest002() {
		//test 011
		//test to not get attendance
		//attendance = 
		//outcome: does not return attendance
		assertEquals(,);
	}
	
	void setEventMaxAttTest001() {
		//test 012
		//test to set attendance
		//attendance = 47
		//outcome: sets attendance at 47
		assertEquals(47);
	}
	
	void getEventBudget001() {
		//test 013
		//test to get budget
		//budget = 500.50
		//outcome: correctly returns budget
		assertEquals(500.50, 500.50);
	}
	
	void getEventBudgetTest002() {
		//test 014
		//test to not get budget
		//budget = 
		//outcome: does not return budget
		assertEquals(,);
	}
	
	void setEventBudgetTest001() {
		//test 015
		//test to set budget
		//budget = 500.50
		//outcome: sets budget at 500.50
		assertEquals(500.50);
	}

	void getEventNotes001() {
		//test 016
		//test to get notes
		//notes = "Gluten-free"
		//outcome: correctly returns notes
		assertEquals("Gluten-free", "Gluten-free");
	}
	
	void getEventBudgetTest002() {
		//test 017
		//test to not get notes
		//notes = 
		//outcome: does not return notes
		assertEquals(,);
	}
	
	void setEventBudgetTest001() {
		//test 018
		//test to get notes
		//notes = "Gluten-free"
		//outcome: correctly sets notes
		assertEquals("Gluten-free");
	}
	
	void getUserID001() {
		//test 019
		//test to get UserID
		//UserID = 2
		//outcome: correctly returns UserID
		assertEquals(2, 2);
	}
	
	void getUserIDTest002() {
		//test 020
		//test to not get UserID
		//notes = 
		//outcome: does not return UserID
		assertEquals(,);
	}
	
	void setUserIDTest001() {
		//test 021
		//test to get UserID
		//UserID = 2
		//outcome: correctly sets UserID
		assertEquals(UserID);
	}
	
	void getUserID001() {
		//test 019
		//test to get User_array
		//User_array = {0,1,2}
		//outcome: correctly returns User_array
		assertEquals(3, {0,1,2});
	}
	
	void getUserIDTest002() {
		//test 020
		//test to not get User_array
		//getUser_array = 
		//outcome: does not return getUser_array
		assertEquals(,);
	}
	
	void setUser_arrayTest001() {
		//test 024
		//test to set User_array
		//getUser_array = {0,1,2}
		//outcome: correctly sets getUser_array
		assertEquals(3, {0,1,2});
	}
}