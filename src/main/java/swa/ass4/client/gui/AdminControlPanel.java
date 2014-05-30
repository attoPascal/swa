package swa.ass4.client.gui;

import javax.swing.JButton;
import javax.ws.rs.client.WebTarget;

import swa.ass4.client.listeners.CreateUser;
import swa.ass4.client.listeners.ManageUsers;
import swa.ass4.client.listeners.UpdatePassword;
import swa.ass4.domain.User;

public class AdminControlPanel extends ControlPanel {
	private static final long serialVersionUID = 1L;
	
	public AdminControlPanel(User user, WebTarget target) {
		super(user);
	    
		JButton b1 = new JButton("Update Password");
		b1.addActionListener(new UpdatePassword(user, target));
		
		JButton b2 = new JButton("Create User");
		b2.addActionListener(new CreateUser(target));
		
		JButton b3 = new JButton("Manage Users");
		b3.addActionListener(new ManageUsers(user, target));
		
	    this.add(b1, "growx");
	    this.add(b2, "growx");
	    this.add(b3, "growx");
	    
	    this.setVisible(true);
	}
}
