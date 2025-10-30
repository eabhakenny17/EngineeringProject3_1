package eventManager;

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
	
	JFrame window = new JFrame("Window");
	
	FlowLayout flowLayout = new FlowLayout();
	
	public UserCreatorGUI()
	{
		// Settup initial window
		window.setLayout(flowLayout);
		
		createAccountButton.addActionListener(this);
		panel.add(nameLabel);
		panel.add(nameText);
		panel.add(passwordLabel);
		panel.add(passwordText);
		panel.add(createAccountButton);
		
		panel.add(messageLabel);
		
		
		window.getContentPane().add(panel);
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
			if (nameText.getText().equals("") || passwordText.getText().equals(""))
			{
				// Show error for invalid username or password
				messageLabel.setText("Error, username or password is invalid");
				window.pack();
				
			}
			// Then check if username is taken
			else if (checkUsernameConflict(nameText.getText()))
			{
				messageLabel.setText("Error, username already taken");
				window.pack();
			}
			// Finally, if all is okay create account
			else
			{
				messageLabel.setText("Creating account...");
				UserAccount newAccount = new UserAccount(nameText.getText(), passwordText.getText(), generateUniqueId());
				newAccount.print();
				
				//TODO Add this to the account array and re-serialize
			}
		}
		
	}
	
	
	public static boolean verifyValidPassword(String password)
	{
		return false;
		// TODO develop method stub
	}
	
	// Make sure username isn't already taken
	// by scanning through user array
	public static boolean checkUsernameConflict(String password)
	{
		return false;
		// TODO develop method stub
	}
	
	// Generate random number
	// then check the user array to ensure it isnt already taken
	// if it isnt return the int, otherwise try again
	public static int generateUniqueId()
	{
		return 0;
		// TODO develop method stub
	}
	
	public static void main(String[] args)
	{
		new UserCreatorGUI();
	}
}
