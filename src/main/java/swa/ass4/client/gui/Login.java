package swa.ass4.client.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class Login extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField usernameField;
	private JTextField passwordField;
	
	public Login() {
		this.setLayout(new MigLayout("wrap 2, fill"));
		
		usernameField = new JTextField();
		passwordField = new JPasswordField();
	    
	    this.add(new JLabel("Username"));
	    this.add(usernameField, "growx");
	    
	    this.add(new JLabel("Password"));
	    this.add(passwordField, "growx");
	}
	
	public String getUsername() {
		return usernameField.getText();
	}
	
	public String getPassword() {
		return passwordField.getText();
	}
}
