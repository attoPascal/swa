package swa.ass4.client.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import swa.ass4.domain.Course;
import swa.ass4.domain.User;
import net.miginfocom.swing.MigLayout;

public class RegisterPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private List<JLabel> courseNames;
	private List<JCheckBox> checkBoxes;
	
	public RegisterPanel(User user, List<Course> courses) {
		this.setLayout(new MigLayout("wrap 2, fill"));
		
		courseNames = new ArrayList<>();
		checkBoxes = new ArrayList<>();
		
		for (Course c : courses) {
			courseNames.add(new JLabel(c.toString()));
			
			JCheckBox cb = new JCheckBox();
			
			if (user.getCourses().containsKey(c)) {
				cb.setSelected(true);
			}
			
			checkBoxes.add(cb);
		}
		
		this.add(new JLabel("COURSE NAME"));
		this.add(new JLabel("REGISTER"));
		
		for (int i = 0; i < courses.size(); i++) {
			this.add(courseNames.get(i));
			this.add(checkBoxes.get(i));
		}
	}

	public List<JCheckBox> getCheckBoxes() {
		return checkBoxes;
	}
}
