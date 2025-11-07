package eventManager;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import javax.swing.*;

public class EventCreation extends JFrame implements ActionListener {
	
    private UserAccount userCreator; 
    public EventCreation(UserAccount userCreator) {
        this.userCreator = userCreator;
    }
    
    private AdminAccount adminCreator; 
    public EventCreation(AdminAccount adminCreator) {
        this.adminCreator = adminCreator;
    }
	
	//private JButton createEventBtn = new JButton("Create an event.");
	private JButton saveEventBtn = new JButton("Save event.");
	//private TextArea textArea = new TextArea("");
	//first window
	//private JFrame startWindow = new JFrame();
	//private JPanel startPanel = new JPanel();
	//second window
	private JFrame eventCreationWindow = new JFrame();
	private JPanel eventCreationPanel = new JPanel();
	
	private JLabel eventNameLabel = new JLabel("Event Name: "); private TextArea eventNameTextArea = new TextArea();
	private JLabel venueLabel = new JLabel("Venue: "); private TextArea venueTextArea = new TextArea();
	private JLabel maxAttendanceLabel = new JLabel("Max Attendance: "); private TextArea maxAttendanceTextArea = new TextArea();
	private JLabel attendanceLabel = new JLabel("Attendance: "); private TextArea attendanceTextArea = new TextArea();
	private JLabel budgetLabel = new JLabel("Budget: "); private TextArea budgetTextArea = new TextArea();
	private JLabel notesLabel = new JLabel("Notes: "); private TextArea notesTextArea = new TextArea();
	
	public void EventGUI() {
		System.out.println("Calling GUI method from EventCreation");
		
		eventCreationWindow.getContentPane().add(eventCreationPanel);
		eventCreationPanel.setSize(400, 400);
		GridLayout layout1 = new GridLayout(7,2);
		eventCreationPanel.setLayout(layout1);
		eventCreationPanel.add(eventNameLabel); eventCreationPanel.add(eventNameTextArea);
		eventCreationPanel.add(venueLabel); eventCreationPanel.add(venueTextArea);
		eventCreationPanel.add(maxAttendanceLabel); eventCreationPanel.add(maxAttendanceTextArea);
		eventCreationPanel.add(attendanceLabel); eventCreationPanel.add(attendanceTextArea);
		eventCreationPanel.add(budgetLabel); eventCreationPanel.add(budgetTextArea);
		eventCreationPanel.add(notesLabel); eventCreationPanel.add(notesTextArea);
		eventCreationPanel.add(saveEventBtn);
		saveEventBtn.addActionListener(this);
		
		eventCreationWindow.add(eventCreationPanel);
        eventCreationWindow.pack();
        eventCreationWindow.setLocationRelativeTo(null);
        eventCreationWindow.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JFrame getEventCreationWindow() {
	    return eventCreationWindow;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(saveEventBtn)) {
	        if (eventNameTextArea.getText().isEmpty() || venueTextArea.getText().isEmpty() || maxAttendanceTextArea.getText().isEmpty() 
	        		|| attendanceTextArea.getText().isEmpty() || budgetTextArea.getText().isEmpty()) {
	                JOptionPane.showMessageDialog(eventCreationWindow, "Please fill in all fields before saving the event.", "Missing Information", JOptionPane.WARNING_MESSAGE);
	                return; 
	            }

	            try {
	                int maxAttendanceInt = Integer.parseInt(maxAttendanceTextArea.getText());
	                int attendanceInt = Integer.parseInt(attendanceTextArea.getText());
	                double budgetDouble = Double.parseDouble(budgetTextArea.getText());

	                Event newEvent = new Event(eventNameTextArea.getText(), venueTextArea.getText(), 
	                           maxAttendanceInt, attendanceInt, budgetDouble, notesTextArea.getText());
	                
	                if (userCreator != null)
	                    newEvent.setUserId(userCreator.getId());
	                if (adminCreator != null) {
	                	newEvent.setUserId(adminCreator.getAId());
	                }

	                EventManager.addEvent(newEvent);
	                System.out.println("saving event...");

	            } catch (NumberFormatException ex) {
	            	System.out.println("user inputted wrong data types #loser");
	            }
			eventCreationWindow.dispose();
		}
	}	
}