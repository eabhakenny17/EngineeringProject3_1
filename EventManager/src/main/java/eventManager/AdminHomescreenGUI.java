package eventManager;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class AdminHomescreenGUI extends JFrame implements ActionListener {

    private AdminAccount user;
    private ArrayList<Event> userEvents;
    private DefaultListModel<String> listModel;
    private JList<String> eventList;
    private JButton viewDetailsButton;
    private JButton createEventButton;

    public AdminHomescreenGUI(AdminAccount user) {
        this.user = user;

        setTitle("Welcome, " + user.getName() + ". You are logged into an admin account.");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        ArrayList<Event> allEvents = EventManager.getAllEvents();
        userEvents = new ArrayList<>();

        for (Event e : allEvents) {
            if (e.getUserId() == user.getAId()) {
                userEvents.add(e);
            }
        }
        
        listModel = new DefaultListModel<>();
        if (userEvents.isEmpty()) {
            listModel.addElement("(No upcoming events found)");
        } else {
            for (Event e : userEvents) {
                listModel.addElement(e.getEventName());
            }
        }
        
        eventList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(eventList);
        add(scrollPane, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        viewDetailsButton = new JButton("View Details");
        viewDetailsButton.addActionListener(this);
        buttonPanel.add(viewDetailsButton);

        createEventButton = new JButton("Create Event");
        createEventButton.addActionListener(this);
        buttonPanel.add(createEventButton);

        add(buttonPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewDetailsButton) {
            int index = eventList.getSelectedIndex();
            if (index == -1 || userEvents.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select a valid event!");
                return;
            }
            Event selectedEvent = userEvents.get(index);
            showEventDetails(selectedEvent);
        }
        
        if(e.getSource() == createEventButton) {
        	EventCreation eventCreation = new EventCreation();
			eventCreation.EventGUI();
        }
    }

    private void showEventDetails(Event event) {
        JFrame frame = new JFrame(event.getEventName());
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(this);

        JTextArea area = new JTextArea();

        String info = "Event: " + event.getEventName() + "\nVenue: " + event.getVenue() + "\nMax Attendance: " + event.getMaxAttendance() + 
        			"\nCurrent Attendance: " + event.getAttendance() + "\nBudget: $" + event.getBudget() + "\n\nNotes:\n" + event.getNotes();

        area.setText(info);
        frame.add(new JScrollPane(area));
        frame.setVisible(true);
    }
}
