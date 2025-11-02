package eventManager;
import java.time.*;
import java.util.*;

import eventManager.Ticket;

public class TicketGen {
	ArrayList<Ticket> ticketList = new ArrayList();
	
	public ArrayList<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(ArrayList<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public TicketGen() {	
		Scanner sc = new Scanner(System.in);
		
		int ticketNo = 1;
		
		System.out.print("Employee name: ");
		String name = sc.next();
		
		System.out.print("Issue: ");
		String body = sc.next();
		
		LocalDateTime dateAndTime = LocalDateTime.now();
		String whenSubmitted = dateAndTime.toString();
		
		Ticket t1 = new Ticket(name, ticketNo, whenSubmitted, body);
		ticketList.add(t1);
		Ticket t2 = new Ticket("john", 2, "1/1/25", "java broke");
		ticketList.add(t2);
		
		System.out.println("Name: "+t1.getSenderName()+", Ticket Number: "+t1.getTicketNumber()+
				", Submitted on: "+t1.getDateSent()+", Issue: "+t1.getTicketBody()+"\n");
		System.out.println("Name: "+t2.getSenderName()+", Ticket Number: "+t2.getTicketNumber()+
				", Submitted on: "+t2.getDateSent()+", Issue: "+t2.getTicketBody()+"\n");
		
		for(Ticket t : ticketList) {
			System.out.println(t);
		}
	}
}