package eventManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class UserHomescreenGUI extends JFrame implements ActionListener
{
	public UserAccount user;
	
	
	
	public UserHomescreenGUI(UserAccount user) 
	{
		this.user = user;
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

}
