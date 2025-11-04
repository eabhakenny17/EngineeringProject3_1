package eventManager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Event implements Serializable {
	private static ArrayList<Event> createdEventsList = new ArrayList<Event>();
    private static final long serialVersionUID = 1L;

    private String eventName;
    private String venue;
    private int maxAttendance;
    private int attendance;
    private double budget;
    private String notes;
    private int user_id;

    public static ArrayList<Event> getCreatedEventsList() {
		return createdEventsList;
	}

	public static void setCreatedEventsList(ArrayList<Event> createdEventsList) {
		Event.createdEventsList = createdEventsList;
	}

	public Event(String eventName, String venue, int maxAttendance, int attendance, double budget, String notes) {
        this.eventName = eventName;
        this.venue = venue;
        this.maxAttendance = maxAttendance;
        this.attendance = attendance;
        this.budget = budget;
        this.notes = notes;
    }

    // Getters and Setters
    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public int getMaxAttendance() { return maxAttendance; }
    public void setMaxAttendance(int maxAttendance) { this.maxAttendance = maxAttendance; }

    public int getAttendance() { return attendance; }
    public void setAttendance(int attendance) { this.attendance = attendance; }

    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public int getUserId() { return user_id; }
    public void setUserId(int user_id) { this.user_id = user_id; }
    
    public void addEvent()
	{
		deSerialiseEventCreationArray();
		createdEventsList.add(this);
		saveEvents();
	}		
	public static ArrayList<Event> createdEventsList()
	{
			
		deSerialiseEventCreationArray();
		return createdEventsList;
	}		
	public static void deleteUsers()
	{
		createdEventsList.clear();
		saveEvents();
	}
	private static void saveEvents()
	{
		try{
			FileOutputStream fo = new FileOutputStream("events.ser");
			ObjectOutputStream oo = new ObjectOutputStream(fo);
				oo.reset();
				oo.writeObject(createdEventsList);
				oo.close();
		}
		catch(Exception e){
				e.printStackTrace();
		}
	}	
	private static void deSerialiseEventCreationArray()		
	{
		try{
			System.out.println("Tring to deserialize");
			FileInputStream fi = new FileInputStream("events.ser");
			ObjectInputStream oi = new ObjectInputStream(fi);
				
			ArrayList<Event> newList = (ArrayList<Event>)oi.readObject();					
			createdEventsList = newList;
			oi.close();
		}
		catch(Exception e){
			e.printStackTrace();
			try{
				saveEvents();
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		}
	}
}
