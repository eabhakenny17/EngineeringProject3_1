package eventManager;

public class Ticket {
	private String senderName;
	private int ticketNumber;
	private String dateSent;
	private String ticketBody;
	
	public String getSenderName() {return senderName;}
	public void setSenderName(String senderName) {this.senderName = senderName;}
	public int getTicketNumber() {return ticketNumber;}
	public void setTicketNumber(int ticketNumber) {this.ticketNumber = ticketNumber;}
	public String getDateSent() {return dateSent;}
	public void setDateSent(String dateSent) {this.dateSent = dateSent;}
	public String getTicketBody() {return ticketBody;}
	public void setTicketBody(String ticketBody) {this.ticketBody = ticketBody;}
	
	public Ticket(String name, int ticketNo, String whenSubmitted, String body) {
		this.senderName = name;
		this.ticketNumber = ticketNo;
		this.dateSent = whenSubmitted;
		this.ticketBody = body;
	}
}