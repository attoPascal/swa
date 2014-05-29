package swa.ass4.client.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class LoginPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField userNameField;
	private JTextField passwordField;
	
	public LoginPanel() {
		this.setLayout(new MigLayout("wrap 2, fill"));
		
		userNameField = new JTextField();
		passwordField = new JPasswordField();
	    
	    this.add(new JLabel("Username"));
	    this.add(userNameField, "growx");
	    
	    this.add(new JLabel("Password"));
	    this.add(passwordField, "growx");
	}
	
	public String getUsername() {
		String userName = userNameField.getText();
		if (userName.equals("")) {
			return ("NoUserName");
		} else {
			return userName;
		}
	}
	
	public String getPassword() {
		String password = passwordField.getText();
		if (password.equals("")) {
			return ("NoPassword");
		} else {
			return password;
		}
	}
}
