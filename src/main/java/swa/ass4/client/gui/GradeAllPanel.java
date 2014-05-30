package swa.ass4.client.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import swa.ass4.domain.Course;
import swa.ass4.domain.User;
import net.miginfocom.swing.MigLayout;

public class GradeAllPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private List<JLabel> userNames;
	private List<JComboBox<User.Grade>> grades;
	
	public GradeAllPanel(Course course, List<User> students) {
		this.setLayout(new MigLayout("wrap 2, fill"));
		
		userNames = new ArrayList<>();
		grades = new ArrayList<>();
		
		for (User u : students) {
			userNames.add(new JLabel(u.getUserName()));
			
			JComboBox<User.Grade> gradeSelect = new JComboBox<>(User.Grade.values());
			User.Grade grade = u.getCourses().get(course);
			
			gradeSelect.setSelectedItem(grade);
			grades.add(gradeSelect);
		}
		
		this.add(new JLabel("USERNAME"));
		this.add(new JLabel("GRADE"));
		
		for (int i = 0; i < students.size(); i++) {
			this.add(userNames.get(i));
			this.add(grades.get(i));
		}
	}

	public List<JLabel> getUserNames() {
		return userNames;
	}

	public List<JComboBox<User.Grade>> getGrades() {
		return grades;
	}
}
