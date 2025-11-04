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
    
//just for testing, currently inactive
    public static void testingKelly() {
        UserAccount user = new UserAccount("Kelly", "1234", 1001);

        Event e1 = new Event("Kelly's Baby Shower", "X207", 100, 45, 250.0, "Bring gifts!");
        e1.setUserId(user.getId());
        EventManager.addEvent(e1);

        Event e2 = new Event("Office Party", "V305", 50, 30, 500.0, "Formal attire required.");
        e2.setUserId(user.getId());
        EventManager.addEvent(e2);

        // Launch GUI
        new UserHomescreenGUI(user);
    }
}
