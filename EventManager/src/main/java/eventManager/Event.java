package eventManager;

import java.io.Serializable;
import java.util.ArrayList;

public class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    private String eventName;
    private String venue;
    private int maxAttendance;
    private int attendance;
    private double budget;
    private String notes;
    // Id of the admin who made this event
    private int user_id;
    
    // Stores all users that should be able to see the array
    private ArrayList<Integer> userArray = new ArrayList<Integer>();

    public Event(String eventName, String venue, int maxAttendance, int attendance, double budget, String notes, ArrayList<Integer> userArray) {
        this.eventName = eventName;
        this.venue = venue;
        this.maxAttendance = maxAttendance;
        this.attendance = attendance;
        this.budget = budget;
        this.notes = notes;
        this.userArray = userArray;
    }
    
//    public Event(String eventName, String venue, int maxAttendance, int attendance, double budget, String notes) {
//        this.eventName = eventName;
//        this.venue = venue;
//        this.maxAttendance = maxAttendance;
//        this.attendance = attendance;
//        this.budget = budget;
//        this.notes = notes;
//    }

    // Getters and setters
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

	public ArrayList<Integer> getUser_array() {return userArray;}
	public void setUser_array(ArrayList<Integer> user_array) {this.userArray = user_array;}
    
    
}
