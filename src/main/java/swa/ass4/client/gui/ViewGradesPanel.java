package swa.ass4.client.gui;

import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import swa.ass4.domain.Course;
import swa.ass4.domain.User;
import net.miginfocom.swing.MigLayout;

public class ViewGradesPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public ViewGradesPanel(Map<Course, User.Grade> courses) {
		this.setLayout(new MigLayout("wrap 2, fill"));
		
		this.add(new JLabel("COURSE"));
		this.add(new JLabel("GRADE"));
		
		for (Map.Entry<Course, User.Grade> e : courses.entrySet()) {
			this.add(new JLabel(e.getKey().toString()));
			this.add(new JLabel(e.getValue().toString()));
		}
	}
}
