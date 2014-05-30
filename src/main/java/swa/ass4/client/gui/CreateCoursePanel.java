package swa.ass4.client.gui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import swa.ass4.domain.Course;

import net.miginfocom.swing.MigLayout;

public class CreateCoursePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField idField;
	private JTextField nameField;
	private JTextField descriptionField;
	private JTextField registrationBeginField;
	private JTextField registrationEndField;
	
	public CreateCoursePanel() {
		this.setLayout(new MigLayout("wrap 2, fill"));
		
		idField = new JTextField();
		nameField = new JTextField();
		descriptionField = new JTextField();
		registrationBeginField = new JTextField("YYYY-MM-DD");
		registrationEndField = new JTextField("YYYY-MM-DD");
	    
	    this.add(new JLabel("ID:"));
	    this.add(idField, "growx");
	    
	    this.add(new JLabel("Name:"));
	    this.add(nameField, "growx");
	    
	    this.add(new JLabel("Description:"), "span");
	    this.add(descriptionField, "span, growx");
	    
	    this.add(new JLabel("Registation Begin/End:"), "span");
	    this.add(registrationBeginField, "growx");
	    this.add(registrationEndField, "growx");
	}
	
	public Course getCourse() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date registrationBegin;
		Date registrationEnd;
		
		try {
			registrationBegin = df.parse(registrationBeginField.getText());
			registrationEnd = df.parse(registrationEndField.getText());
		} catch (ParseException e) {
			registrationBegin = null;
			registrationEnd = null;
		}
		
		return new Course(
			Integer.parseInt(idField.getText()),
			nameField.getText(),
			descriptionField.getText(),
			null,
			registrationBegin,
			registrationEnd
		);
	}
}
