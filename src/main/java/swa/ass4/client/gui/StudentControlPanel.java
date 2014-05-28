package swa.ass4.client.gui;

import javax.swing.JButton;

public class StudentControlPanel extends ControlPanel {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Erstellt GUI
	 */
	public StudentControlPanel() {
		super();
		
		this.setTitle("Student Control Panel");
	    
	    this.add(new JButton("Student Zeug"));
	    
	    this.setVisible(true);
	}
}
