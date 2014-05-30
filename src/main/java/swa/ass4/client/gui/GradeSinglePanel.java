package swa.ass4.client.gui;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import swa.ass4.domain.Course;
import swa.ass4.domain.User;
import net.miginfocom.swing.MigLayout;

public class GradeSinglePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JComboBox<User> userSelect;
	private JComboBox<User.Grade> gradeSelect;

	public GradeSinglePanel(Course course, List<User> students) {
		this.setLayout(new MigLayout("wrap 2, fill"));
		
		User[] studentArray = students.toArray(new User[students.size()]);
		userSelect = new JComboBox<>(studentArray);
		gradeSelect = new JComboBox<>(User.Grade.values());

		this.add(userSelect);
		this.add(gradeSelect);
	}

	public User getUser() {
		return userSelect.getItemAt(userSelect.getSelectedIndex());
	}

	public User.Grade getGrade() {
		return gradeSelect.getItemAt(gradeSelect.getSelectedIndex());
	}
}
