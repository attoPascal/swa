package swa.ass4.client.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import swa.ass4.client.gui.ViewGradesPanel;
import swa.ass4.domain.User;

public class ViewGrades implements ActionListener {
	private User user;
	
	public ViewGrades(User user) {
		this.user = user;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ViewGradesPanel panel = new ViewGradesPanel(user.getCourses());
		JOptionPane.showMessageDialog(null, panel, "Register", JOptionPane.PLAIN_MESSAGE);
	}
}
