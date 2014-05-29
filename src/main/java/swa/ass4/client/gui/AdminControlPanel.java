package swa.ass4.client.gui;

import javax.swing.JButton;
import javax.ws.rs.client.WebTarget;

import swa.ass4.client.listeners.CreateUser;
import swa.ass4.client.listeners.UpdatePassword;
import swa.ass4.domain.User;

public class AdminControlPanel extends ControlPanel {
	private static final long serialVersionUID = 1L;
	
	public AdminControlPanel(User user, WebTarget target) {
		super(user);
	    
		JButton b1 = new JButton("Update Password");
		b1.addActionListener(new UpdatePassword(user, target));
		
		JButton b2 = new JButton("Create User");
		b2.addActionListener(new CreateUser(user, target));
		
	    this.add(b1, "growx");
	    this.add(b2, "growx");
	    this.add(new JButton("Delete Users"), "growx");
	    this.add(new JButton("Assign Roles"), "growx");
	    
	    this.setVisible(true);
	}
}
