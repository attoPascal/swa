package swa.ass4.client.gui;

import javax.swing.JButton;
import javax.ws.rs.client.WebTarget;

import swa.ass4.client.listeners.CreateCourse;
import swa.ass4.client.listeners.GradeAll;
import swa.ass4.client.listeners.GradeSingle;
import swa.ass4.client.listeners.UpdatePassword;
import swa.ass4.domain.User;

public class TeacherControlPanel extends ControlPanel {
	private static final long serialVersionUID = 1L;
	
	public TeacherControlPanel(User user, WebTarget target) {
		super(user);
	    
		JButton b1 = new JButton("Update Password");
		b1.addActionListener(new UpdatePassword(user, target));
		
		JButton b2 = new JButton("Create Course");
		b2.addActionListener(new CreateCourse(user, target));
		
		JButton b3 = new JButton("Grade All");
		b3.addActionListener(new GradeAll(user, target));
		
		JButton b4 = new JButton("Grade Single");
		b4.addActionListener(new GradeSingle(user, target));
		
		this.add(b1, "growx");
	    this.add(b2, "growx");
	    this.add(b3, "growx");
	    this.add(b4, "growx");
	    
	    this.setVisible(true);
	}
}