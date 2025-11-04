package eventManager;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import eventManager.Event;

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
            ArrayList<Event> updatedEvents = new ArrayList<>();
            for (Event ev : Event.getCreatedEventsList()) {
                if (ev.getUserId() == user.getAId()) {
                    updatedEvents.add(ev);
                }
            }

            if (index >= updatedEvents.size()) {
                return;
            }

            Event selectedEvent = updatedEvents.get(index);
            showEventDetails(selectedEvent);
        }
        
        if (e.getSource() == createEventButton) {
            EventCreation eventCreation = new EventCreation(user);
            eventCreation.EventGUI();

            eventCreation.getEventCreationWindow().addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent we) {
                    refreshEventList();
                }
            });
        }
    }

    private void showEventDetails(Event event) {
    	 ArrayList<Event> eventList = Event.getCreatedEventsList();

    	    JTextArea area = new JTextArea();
    	    area.setEditable(false);

    	    StringBuilder info = new StringBuilder();

    	    for (Event e : eventList) {
    	        info.append("Event: ").append(e.getEventName()).append("\nVenue: ").append(e.getVenue()).append("\nMax Attendance: ").append(e.getMaxAttendance()).append("\nCurrent Attendance: ").append(e.getAttendance()).append("\nBudget: $").append(e.getBudget()).append("\nNotes: ").append(e.getNotes()).append("\n----------------------------------------\n");
    	    }

    	    if (eventList.isEmpty()) {
    	        info.append("(No events have been created yet.)");
    	    }

    	    area.setText(info.toString());
    }
    
    public void refreshEventList() {
        listModel.clear();
        userEvents.clear();

        ArrayList<Event> allEvents = Event.getCreatedEventsList();

        for (Event e : allEvents) {
            if (e.getUserId() == user.getAId()) {
                userEvents.add(e);
                listModel.addElement(e.getEventName());
            }
        }

        if (userEvents.isEmpty()) {
            listModel.addElement("(No upcoming events found)");
        }

        System.out.println("Event list refreshed for " + user.getName());
    }

}
