package eventManager;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class EventCreation extends JFrame implements ActionListener {
	private JButton createEventBtn = new JButton("Create an event.");
	private TextArea textArea = new TextArea("");
	//first window
	private JFrame startWindow = new JFrame();
	private JPanel startPanel = new JPanel();
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
		startPanel.add(createEventBtn);
		createEventBtn.addActionListener(this);
		startWindow.getContentPane().add(startPanel);
		startWindow.pack();
		startWindow.setVisible(true);
		
		GridLayout layout1 = new GridLayout(6,2); //three columns, two rows
		eventCreationPanel.setLayout(layout1);
		eventCreationPanel.add(eventNameLabel); eventCreationPanel.add(eventNameTextArea);
		eventCreationPanel.add(venueLabel); eventCreationPanel.add(venueTextArea);
		eventCreationPanel.add(maxAttendanceLabel); eventCreationPanel.add(maxAttendanceTextArea);
		eventCreationPanel.add(attendanceLabel); eventCreationPanel.add(attendanceTextArea);
		eventCreationPanel.add(budgetLabel); eventCreationPanel.add(budgetTextArea);
		eventCreationPanel.add(notesLabel); eventCreationPanel.add(notesTextArea);
		eventCreationWindow.getContentPane().add(eventCreationPanel);
		eventCreationWindow.pack();
		eventCreationWindow.setVisible(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Scanner sc = new Scanner(System.in);
		if(e.getSource().equals(createEventBtn)){
			eventCreationWindow.setVisible(true);
			startWindow.setVisible(false);
			//eventNameTextArea.setText();
		}
	}	
}