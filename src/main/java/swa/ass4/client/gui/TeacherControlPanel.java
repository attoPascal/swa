package swa.ass4.client.gui;

import javax.swing.JButton;
import javax.ws.rs.client.WebTarget;

import swa.ass4.client.listeners.UpdatePassword;
import swa.ass4.domain.User;

public class TeacherControlPanel extends ControlPanel {
	private static final long serialVersionUID = 1L;
	
	public TeacherControlPanel(User user, WebTarget target) {
		super(user);
	    
		JButton b1 = new JButton("Update Password");
		b1.addActionListener(new UpdatePassword(user, target));
		
		this.add(b1, "growx");
	    this.add(new JButton("Create Course"), "growx");
	    this.add(new JButton("Grade All"), "growx");
	    this.add(new JButton("Grade Single"), "growx");
	    
	    this.setVisible(true);
	}
}