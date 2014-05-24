package swa.ass4.client.gui;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

public class LoginGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JLabel            userTypeLabel   = new JLabel("User type:");
	private String[]          userTypeStrings = {"Administrator", "Student", "Teacher"};
	private JComboBox<String> userTypeSelect  = new JComboBox<>(userTypeStrings);
	
	private JLabel    userNameLabel = new JLabel("Username:");
	private TextField userNameField = new TextField();
	
	private JLabel    passwordLabel = new JLabel("Password:");
	private TextField passwordField = new TextField();
	
	private JButton loginButton = new JButton("Login");
	
	/**
	 * Erstellt GUI
	 */
	public LoginGUI() {
		MigLayout layout = new MigLayout("wrap 2, fill");
	    
		this.setLayout(layout);
		this.setSize(320, 200);   
	    this.setResizable(false);
		this.setTitle("Login");
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    this.add(userTypeLabel);
	    this.add(userTypeSelect, "growx");
	    
	    this.add(userNameLabel);
	    this.add(userNameField, "growx");
	    
	    this.add(passwordLabel);
	    this.add(passwordField, "growx");
	    
	    this.add(loginButton);
	    
	    this.setVisible(true);
	}
	
	/**
	 * Wird beim Klicken des OK-Buttons ausgefuehrt
	 */
	public void actionPerformed(ActionEvent arg0) {		

	}
}
