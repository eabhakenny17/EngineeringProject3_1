package eventManager;

import java.io.Serializable;

public class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    private String eventName;
    private String venue;
    private int maxAttendance;
    private int attendance;
    private double budget;
    private String notes;
    private int user_id;

    public Event(String eventName, String venue, int maxAttendance, int attendance, double budget, String notes) {
        this.eventName = eventName;
        this.venue = venue;
        this.maxAttendance = maxAttendance;
        this.attendance = attendance;
        this.budget = budget;
        this.notes = notes;
    }

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
}
