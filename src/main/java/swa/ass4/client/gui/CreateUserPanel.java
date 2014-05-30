package swa.ass4.client.gui;

import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import swa.ass4.domain.Course;
import swa.ass4.domain.User;
import net.miginfocom.swing.MigLayout;

public class CreateUserPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField userNameField;
	private JTextField passwordField;
	private JComboBox<User.Role> roleSelect;
	
	public CreateUserPanel() {
		this.setLayout(new MigLayout("wrap 2, fill"));
		
		firstNameField = new JTextField();
		lastNameField = new JTextField();
		userNameField = new JTextField();
		passwordField = new JPasswordField();
		roleSelect = new JComboBox<>(User.Role.values());
	    
	    this.add(new JLabel("First Name:"));
	    this.add(firstNameField, "growx");
	    
	    this.add(new JLabel("Last Name:"));
	    this.add(lastNameField, "growx");
	    
	    this.add(new JLabel("User Name:"));
	    this.add(userNameField, "growx");
	    
	    this.add(new JLabel("Password:"));
	    this.add(passwordField, "growx");
	    
	    this.add(new JLabel("Role:"));
	    this.add(roleSelect, "growx");
	}
	
	public User getUser() {
		return new User(
			firstNameField.getText(),
			lastNameField.getText(),
			userNameField.getText(),
			passwordField.getText(),
			roleSelect.getItemAt(roleSelect.getSelectedIndex()),
			new HashMap<Course, User.Grade>()
		);
	}
}
