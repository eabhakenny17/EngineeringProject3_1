package eventManager;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class EventTest {
	void getEventName001test() {
		//test 001
		//test to get event name
		//event name = "Birthday Party"
		//outcome: correctly returns event name
		
		Event testEvent = new Event("Birthday Party","Test" , 100 , 10 , 100.00 , "Notes", null );
		
		assertEquals("Birthday Party", testEvent.getEventName());
	}
	
	
	void setEventName002test() {
		//test 002
		//test to set event name
		//event name = "Not Birthday Party" newName = "Birthday Party
		//outcome: sets event name as "Birthday Party"
		
		Event testEvent = new Event("Not Birthday Party","Test" , 100 , 10 , 100.00 , "Notes", null );
		String newName = "BirthdayParty";
		
		testEvent.setEventName(newName);
		assertEquals("Birthday Party", testEvent.getEventName());
	}
	
	void getEventVenue003test() {
		//test 003
		//test to get event venue
		//venue = "Test" 
		//outcome: correctly returns event venue
		Event testEvent = new Event("Birthday Party","Test" , 100 , 10 , 100.00 , "Notes", null );
		
		assertEquals("Test", testEvent.getVenue());
	}
	
	void setEventVenue004test() {
		//test 004
		//test to set event venue
		//event venue = "Wrong Venue", newVenue = "Test"
		//outcome: sets event Venue as "Test"
		Event testEvent = new Event("Birthday Party","Wrong Venue" , 100 , 10 , 100.00 , "Notes", null );
		String newVenue = "Test";
		
		testEvent.setVenue(newVenue);
		
		assertEquals("Test", testEvent.getVenue());
	}
	
	void getMaxAttendance005test() {
		//test 005
		//test to get max attendance
		//max attendance = 50
		//outcome: correctly returns max attendance
		
		Event testEvent = new Event("Birthday Party","Wrong Venue" , 50 , 10 , 100.00 , "Notes", null );
		assertEquals(50, testEvent.getMaxAttendance());
	}
	
	
	void setEventMaxAttendance006test() {
		//test 006
		//test to set max attendance
		//max attendance = 25, newMax = 50
		//outcome: sets max attendance at 50
		Event testEvent = new Event("Birthday Party","Wrong Venue" , 25 , 10 , 100.00 , "Notes", null );
		int newMax = 50;
		
		testEvent.setMaxAttendance(newMax);
		
		assertEquals(25, testEvent.getMaxAttendance());
	}

	void getEventAttendance007test() {
		//test 007
		//test to get attendance
		//attendance = 10
		//outcome: correctly returns attendance
		
		Event testEvent = new Event("Birthday Party","Wrong Venue" , 25 , 10 , 100.00 , "Notes", null );
		
		assertEquals(10, testEvent.getAttendance());
	}
	
	
	void setEventAttendance008test() {
		//test 008
		//test to set attendance
		//attendance = 5, newAttendance = 10
		//outcome: sets attendance at 10
		
		Event testEvent = new Event("Birthday Party","Wrong Venue" , 25 , 5 , 100.00 , "Notes", null );
		int newAttendance = 10;
		
		testEvent.setAttendance(newAttendance);
		
		assertEquals(10, testEvent.getAttendance());
	}
	
	void getEventBudget009test() {
		//test 009
		//test to get budget
		//double budget = 500.50
		//outcome: correctly returns budget
		
		Event testEvent = new Event("Birthday Party","Wrong Venue" , 25 , 5 , 500.50 , "Notes", null );
		
		assertEquals(500.50, testEvent.getBudget());
	}
	
	
	void setEventBudgetTest010() {
		//test 010
		//test to set budget
		//double budget = 100.50, newBudget = 500.50
		//outcome: sets budget at 500.50
		Event testEvent = new Event("Birthday Party","Wrong Venue" , 25 , 5 , 100.50 , "Notes", null );
		double newBudget = 500.50;
		
		testEvent.setBudget(newBudget);
		
		assertEquals(500.50, testEvent.getBudget());
	}

	void getEventNotes011test() {
		//test 011
		//test to get notes
		//notes = "Notes"
		//outcome: correctly returns notes
		
		Event testEvent = new Event("Birthday Party","Wrong Venue" , 25 , 5 , 100.50 , "Notes", null );
		
		assertEquals("Notes", testEvent.getNotes());
	}
	
	void setEventBudget012test() {
		//test 012
		//test to get notes
		//notes = "not note", newNote = "Notes"
		//outcome: correctly sets notes
		
		Event testEvent = new Event("Birthday Party","Wrong Venue" , 25 , 5 , 100.50 , "not note", null );
		String newNote = "Notes";
		
		testEvent.setNotes(newNote);
		
		assertEquals("Notes", testEvent.getNotes());
	}
	
	void getUserArray013test() {
		//test 013
		//test to get UserID
		//UserArray = new ArrayList<Integer> {1,2}
		//outcome: correctly returns UserID
		
		ArrayList<Integer> intArrayList = new ArrayList<Integer>();
		intArrayList.add(1);
		intArrayList.add(2);
		
		Event testEvent = new Event("Birthday Party","Wrong Venue" , 25 , 5 , 100.50 , "Notes", intArrayList );
		
		assertEquals(intArrayList, testEvent.getUser_array());
	}
	
	void setUserArray014test() {
		//test 014
		//test to get UserID
		//badArray = new ArrayList<Integer> {1,1}, goodArray = new ArrayList<Integer> {1,2}
		//outcome: correctly returns UserID
		
		ArrayList<Integer> badArray = new ArrayList<Integer>();
		badArray.add(1);
		badArray.add(1);
		
		ArrayList<Integer> goodArray = new ArrayList<Integer>();
		goodArray.add(1);
		goodArray.add(2);
		
		Event testEvent = new Event("Birthday Party","Wrong Venue" , 25 , 5 , 100.50 , "Notes", badArray);
		testEvent.setUser_array(goodArray);
		
		assertEquals(goodArray, testEvent.getUser_array());
	}
	

}