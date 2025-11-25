package eventManager;
import java.util.ArrayList;

import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.*;

public class UserCreatorGUI extends JFrame implements ActionListener
{
	
	private JButton createAccountButton = new JButton("Create Account");
	
	private JPanel panel = new JPanel();

	private JLabel nameLabel = new JLabel("Name: ");
	private JLabel passwordLabel = new JLabel("Password: ");
	
	private TextArea nameText = new TextArea();
	private TextArea passwordText = new TextArea();
	
	private JLabel messageLabel = new JLabel("");
	
	JFrame window = new JFrame("Create Account");
	
	FlowLayout flowLayout = new FlowLayout();
	
	public UserCreatorGUI()
	{
		// Setup initial window
		//window.setLayout(flowLayout);
        window.add(panel);
        panel.setLayout(new GridLayout(1, 3));
		
		createAccountButton.addActionListener(this);
		panel.add(nameLabel);
		panel.add(nameText);
		panel.add(passwordLabel);
		panel.add(passwordText);
		panel.add(createAccountButton);
		
		panel.add(messageLabel);
		
		
		//window.getContentPane().add(panel);
		window.pack();
		window.setVisible(true);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(createAccountButton))
		{
			System.out.println("Button Pressed");
			
			// Makes sure name or password are not empty
			if ( !(UserAccount.verifyValidUsername(nameText.getText()) && UserAccount.verifyValidPassword(passwordText.getText())))
			{
				// Show error for invalid username or password
				messageLabel.setText("Error, username or password is invalid");
				window.pack();
				
			}
			// Then check if username is taken
			else if (UserAccount.checkUsernameConflict(nameText.getText()))
			{
				messageLabel.setText("Error, username already taken");
				window.pack();
			}
			// Finally, if all is okay create account
			else
			{
				messageLabel.setText("Creating account...");
				UserAccount newAccount = new UserAccount(nameText.getText(), passwordText.getText(), UserAccount.generateUniqueId());
				
				newAccount.addUser();
				
				window.setVisible(false);
				

				// For debugging, gets and prints out entire user list
//				ArrayList<UserAccount>userList = UserAccount.getUserList();
//				
//				for (UserAccount item : userList)
//				{
//					item.print();
//				}
			}
		}
		
	}
	

}
