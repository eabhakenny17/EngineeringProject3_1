package eventManager;

import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import eventManager.UserHomescreenGUI;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class UserLoginGUI extends JFrame implements ActionListener
{
	
	private Login login = new Login();
	
	private JButton loginButton = new JButton("Login");
	
	private JPanel panel = new JPanel();

	private JLabel nameLabel = new JLabel("Name: ");
	private JLabel passwordLabel = new JLabel("Password: ");
	
	private TextArea nameText = new TextArea();
	private TextArea passwordText = new TextArea();
	
	private JLabel messageLabel = new JLabel("");
	
	JFrame window = new JFrame("Create Account");
	
	FlowLayout flowLayout = new FlowLayout();
	
	private UserAccount loggedInUser; 
	
	public UserLoginGUI() 
	{
		// Setup initial window
			window.setLayout(flowLayout);
				
			loginButton.addActionListener(this);
			panel.add(nameLabel);
			panel.add(nameText);
			panel.add(passwordLabel);
			panel.add(passwordText);
			panel.add(loginButton);
			
			panel.add(messageLabel);
			
			
			window.getContentPane().add(panel);
			window.pack();
			window.setVisible(true);
			
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(loginButton))
		{
			int userId = login.attemptLogin(nameText.getText(), passwordText.getText());
			
			if (userId == 0)
			{
				messageLabel.setText("Error: Invalid username or password");
				window.pack();
			}
			else
			{
				new UserHomescreenGUI(login.signInViaID(userId));
				window.setVisible(false);
			}
		}
		
	}
}

//public void actionPerformed(ActionEvent e) {
//    if (e.getSource() == loginButton) {
//        String name = nameText.getText().trim();
//        String password = passwordText.getText().trim();
//
//        // Ensure we have the latest user data
//        ArrayList<UserAccount> users = UserAccount.getUserList();
//
//        // Declare final variable so it can be used inside lambda
//        final UserAccount loggedInUser = users.stream()
//            .filter(u -> u.getName().equals(name) && u.getPassword().equals(password))
//            .findFirst()
//            .orElse(null);
//
//        if (loggedInUser == null) {
//            messageLabel.setText("Invalid username or password!");
//        } else {
//            messageLabel.setText("Login successful!");
//
//            SwingUtilities.invokeLater(() -> new UserHomescreenGUI(loggedInUser));
//
//            // Close the login window
//            window.dispose();
//        }
//    }
//}
