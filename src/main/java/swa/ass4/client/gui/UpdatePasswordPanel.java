package swa.ass4.client.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class UpdatePasswordPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField oldPasswordField;
	private JTextField newPasswordField1;
	private JTextField newPasswordField2;
	
	public UpdatePasswordPanel() {
		this.setLayout(new MigLayout("wrap 2, fill"));
		
		oldPasswordField  = new JPasswordField();
		newPasswordField1 = new JPasswordField();
		newPasswordField2 = new JPasswordField();
	    
	    this.add(new JLabel("Old Password:"));
	    this.add(oldPasswordField, "growx");
	    
	    this.add(new JLabel("New Password:"));
	    this.add(newPasswordField1, "growx");
	    
	    this.add(new JLabel("Repeat New Password:"));
	    this.add(newPasswordField2, "growx");
	}
	
	public String getOldPassword() {
		String password = oldPasswordField.getText();
		if (password.equals("")) {
			throw new RuntimeException("No old password given");
		} else {
			return password;
		}
	}
	
	public String getNewPassword() {
		String password = newPasswordField1.getText();
		if (password.equals("")) {
			throw new RuntimeException("No new password given");
		
		} else if (!password.equals(newPasswordField2.getText())) {
			throw new RuntimeException("New passwords do not match");
			
		} else {
			return password;
		}
	}
}
