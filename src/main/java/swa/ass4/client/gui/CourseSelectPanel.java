package swa.ass4.client.gui;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import swa.ass4.domain.Course;
import net.miginfocom.swing.MigLayout;

public class CourseSelectPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JComboBox<Course> courseSelect;
	
	public CourseSelectPanel(List<Course> courses) {
		this.setLayout(new MigLayout("wrap 1, fill"));
		
		Course[] courseArray = courses.toArray(new Course[courses.size()]);
		courseSelect = new JComboBox<Course>(courseArray);
		
		this.add(courseSelect);
	}

	public Course getCourse() {
		return courseSelect.getItemAt(courseSelect.getSelectedIndex());
	}
}
