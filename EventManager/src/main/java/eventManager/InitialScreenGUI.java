package eventManager;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InitialScreenGUI extends JFrame implements ActionListener
{
	private JPanel panel = new JPanel();
	
	private JButton loginButton = new JButton("Log In");
	private JButton registerButton = new JButton("Register");
	
	private JButton deleteAllButton = new JButton("DELETE ALL");
	
	JFrame window = new JFrame("Welcome!");
		
	FlowLayout flowLayout = new FlowLayout();
	
	public InitialScreenGUI()
	{
		loginButton.addActionListener(this);
		registerButton.addActionListener(this);
		deleteAllButton.addActionListener(this);
		
		panel.add(loginButton);
		panel.add(registerButton);
		panel.add(deleteAllButton);
		
		window.getContentPane().add(panel);
		window.pack();
		window.setVisible(true);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Setup initial window
		window.setLayout(flowLayout);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(loginButton))
		{
			new UserLoginGUI();
			window.setVisible(false);
			
		}
		if (e.getSource().equals(registerButton))
		{
			new UserCreatorGUI();
		}
		if(e.getSource().equals(deleteAllButton))
		{
			UserAccount.deleteUsers();
		}
		
	}
}
