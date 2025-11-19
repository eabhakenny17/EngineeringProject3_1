package eventManager;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class AdminHomescreenGUI extends JFrame implements ActionListener {

    private AdminAccount admin;
    private ArrayList<Event> adminEvents;
    private DefaultListModel<String> listModel;
    private JList<String> eventList;
    private JButton viewDetailsButton;
    private JButton createEventButton;
    private JButton deleteEventButton;

    public AdminHomescreenGUI(AdminAccount admin) {
        this.admin = admin;

        setTitle("Welcome, " + admin.getName() + " (Admin)");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ArrayList<Event> allEvents = EventManager.getAllEvents();
        adminEvents = new ArrayList<>();

        for (Event e : allEvents) {
            if (e.getUserId() == admin.getAId()) {
                adminEvents.add(e);
            }
        }

        listModel = new DefaultListModel<>();
        if (adminEvents.isEmpty()) {
            listModel.addElement("No upcoming events found");
        } 
        else {
            for (Event e : adminEvents) {
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
        
        deleteEventButton = new JButton("Delete Event");
        deleteEventButton.addActionListener(this);
        buttonPanel.add(deleteEventButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewDetailsButton) {
            int index = eventList.getSelectedIndex();
            if (index == -1 || adminEvents.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select a valid event!");
            }

            Event selectedEvent = adminEvents.get(index);
            showEventDetails(selectedEvent);
        }

        if (e.getSource() == createEventButton) {
            EventCreation eventCreation = new EventCreation(admin);
            eventCreation.EventGUI();

            // Refresh list after event window closes
            eventCreation.getEventCreationWindow().addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent we) {
                    refreshEventList();
                }
            });
        }
        
        // If it is the delete button
        if (e.getSource() == deleteEventButton)
        {
        	// Get the selected event
        	int index = eventList.getSelectedIndex();
            if (index == -1 || adminEvents.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select a valid event!");
            }

            Event selectedEvent = adminEvents.get(index);
            // and delete it
            EventManager.removeEvent(selectedEvent);
            
            refreshEventList();
        }
    }

    private void showEventDetails(Event event) {
        JFrame frame = new JFrame(event.getEventName());
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(this);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        StringBuilder info = new StringBuilder();
        int adminId = admin.getAId();

        ArrayList<Event> allEvents = EventManager.getAllEvents();
        for (Event e : allEvents) {
            if (e.getUserId() == adminId) {
                info.append("Event: ").append(e.getEventName()).append("\nVenue: ").append(e.getVenue()).append("\nMax Attendance: ").append(e.getMaxAttendance())
                .append("\nActual Attendance: ").append(e.getAttendance()).append("\nBudget: $").append(e.getBudget()).append("\nNotes: ").append(e.getNotes());
            }
        }

        if (info.length() == 0) {
            info.append("(No events found for this admin)");
        }

        area.setText(info.toString());
        frame.add(new JScrollPane(area));
        frame.setVisible(true);
    }

    public void refreshEventList() {
        listModel.clear();
        adminEvents.clear();

        ArrayList<Event> allEvents = EventManager.getAllEvents();

        for (Event e : allEvents) {
            if (e.getUserId() == admin.getAId()) {
                adminEvents.add(e);
                listModel.addElement(e.getEventName());
            }
        }

        if (adminEvents.isEmpty()) {
            listModel.addElement("(No upcoming events found)");
        }

        System.out.println("Event list refreshed for admin: " + admin.getName());
    }
}
