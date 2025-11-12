package eventManager;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class UserHomescreenGUI extends JFrame implements ActionListener {

    private UserAccount user;
    private ArrayList<Event> userEvents;
    private DefaultListModel<String> listModel;
    private JList<String> eventList;
    private JButton viewDetailsButton;
    private JButton createEventButton;

    public UserHomescreenGUI(UserAccount user) {
        this.user = user;

        setTitle("Welcome, " + user.getName());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        ArrayList<Event> allEvents = EventManager.getAllEvents();
        userEvents = new ArrayList<>();

        for (Event e : allEvents) {
            if (e.getUserId() == user.getId()) {
                userEvents.add(e);
            }
        }
        
        listModel = new DefaultListModel<>();
        if (userEvents.isEmpty()) {
            listModel.addElement("No upcoming events found");
        } else {
            for (Event e : userEvents) {
                listModel.addElement(e.getEventName());
            }
        }
        
        eventList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(eventList);
        add(scrollPane, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

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
            }

            Event selectedEvent = userEvents.get(index);
            showEventDetails(selectedEvent);
        }

        if (e.getSource() == createEventButton) {
            EventCreation eventCreation = new EventCreation(user);
            eventCreation.EventGUI();

            // Refresh list after event window closes
            eventCreation.getEventCreationWindow().addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent we) {
                    refreshEventList();
                }
            });
        }
    }

    private void showEventDetails(Event event) {
        JFrame frame = new JFrame(event.getEventName());
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(this);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        
        StringBuilder info = new StringBuilder();
        int adminId = user.getId();

        ArrayList<Event> allEvents = EventManager.getAllEvents();
        for (Event e : allEvents) {
            if (e.getUserId() == user.getId()) {
    	        info.append("Event: ").append(e.getEventName()).append("\nVenue: ").append(e.getVenue()).append("\nMax Attendance: ").append(e.getMaxAttendance()).append("\nCurrent Attendance: ").append(e.getAttendance()).append("\nBudget: $").append(e.getBudget()).append("\nNotes: ").append(e.getNotes()).append("\n----------------------------------------\n");
    	    }
        }

        if (count == 0) {
        	System.out.println("jenkins test");
            info.append("No events");
        }

        area.setText(info.toString());
        frame.add(new JScrollPane(area));
        frame.setVisible(true);
    }
    
    public void refreshEventList() {
        listModel.clear();
        userEvents.clear();

        ArrayList<Event> allEvents = EventManager.getAllEvents();;

        for (Event e : allEvents) {
            if (e.getUserId() == user.getId()) {
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
