package eventManager;

public class Event 
{
	private String eventName;
	private String eventDiscription;
	private int creatorsId;
	private int peopleAttending;
	
	
	
	
	
	public Event(String eventName, String eventDiscription, int creatorsId, int peopleAttending) 
	{
		this.eventName = eventName;
		this.eventDiscription = eventDiscription;
		this.peopleAttending = peopleAttending;
		this.creatorsId = creatorsId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDiscription() {
		return eventDiscription;
	}

	public void setEventDiscription(String eventDiscription) {
		this.eventDiscription = eventDiscription;
	}

	public int getPeopleAttending() {
		return peopleAttending;
	}

	public void setPeopleAttending(int peopleAttending) {
		this.peopleAttending = peopleAttending;
	}

	public int getCreatorsId() {
		return creatorsId;
	}

	public void setCreatorsId(int creatorsId) {
		this.creatorsId = creatorsId;
	}

	
	
}
