package eventManager;

import java.io.*;
import java.util.ArrayList;

public class EventManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private static ArrayList<Event> events = new ArrayList<>();

    public static void addEvent(Event event) 
    {
        loadEvents(); 
        events.add(event);
        saveEvents();
    }
    
    public static void removeEvent(Event event)
    {
    	loadEvents();
//    	System.out.println("Attempting to remove event...");
    	
    	for (int i = 0 ; i < events.size(); i++)
    	{
    		if (events.get(i).equals(event))
    		{
    			events.remove(i);
    			System.out.println("Event Removed!");
    		}
    	}
    	saveEvents();
    }

    public static ArrayList<Event> getAllEvents() {
        loadEvents();
        return events;
    }

    public static ArrayList<Event> getEventsForUser(int userId) {
        loadEvents();
        ArrayList<Event> userEvents = new ArrayList<>();
        for (Event e : events) {
            if (e.getUserId() == userId) {
                userEvents.add(e);
            }
        }
        return userEvents;
    }

    private static void saveEvents() {
        try (FileOutputStream fileOut = new FileOutputStream("events.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(events);
            System.out.println("Events saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadEvents() {
        try (FileInputStream fileIn = new FileInputStream("events.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            events = (ArrayList<Event>) in.readObject();
        } catch (Exception e) {
            events = new ArrayList<>();
        }
    }
    
    

}
