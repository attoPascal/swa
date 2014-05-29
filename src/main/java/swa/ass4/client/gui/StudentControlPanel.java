package swa.ass4.client.gui;

import javax.swing.JButton;
import javax.ws.rs.client.WebTarget;

import swa.ass4.client.listeners.UpdatePassword;
import swa.ass4.domain.User;

public class StudentControlPanel extends ControlPanel {
	private static final long serialVersionUID = 1L;

	public StudentControlPanel(User user, WebTarget target) {
		super(user);
		
		JButton b1 = new JButton("Update Password");
		b1.addActionListener(new UpdatePassword(user, target));
		
		JButton b2 = new JButton("Register");
		b2.addActionListener(null);
		
		JButton b3 = new JButton("Deregister");
		b3.addActionListener(null);
		
		JButton b4 = new JButton("View Grades");
		b4.addActionListener(null);
		
		this.add(b1, "growx");
		this.add(b2, "growx");
		this.add(b3, "growx");
		this.add(b4, "growx");

		this.setVisible(true);
	}
}
