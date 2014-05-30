package swa.ass4.client.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import swa.ass4.client.gui.RegisterPanel;
import swa.ass4.domain.Course;
import swa.ass4.domain.User;

public class Register implements ActionListener {
	private User user;
	private WebTarget target;
	
	public Register(User user, WebTarget target) {
		this.user = user;
		this.target = target;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		WebTarget coursesTarget = target.path("courses");
		List<Course> courses = coursesTarget.request(MediaType.TEXT_XML).get(new GenericType<List<Course>>() {});
		
		// remove courses with invalid registration timeframe
		Iterator<Course> it = courses.iterator();
		while (it.hasNext()) {
			Course c = it.next();
			Date registrationBegin = c.getRegistrationBegin();
			Date registrationEnd = c.getRegistrationEnd();
			Date now = new Date();
			
			if (now.before(registrationBegin) || now.after(registrationEnd)) {
				it.remove();
			}
		}
		
		RegisterPanel panel = new RegisterPanel(user, courses);
		int result = JOptionPane.showConfirmDialog(null, panel, "Register", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (result == JOptionPane.OK_OPTION) {
			List<JCheckBox> checkBoxes = panel.getCheckBoxes();
			
			for (int i = 0; i < courses.size(); i++) {
				Course c = courses.get(i);
				Map<Course, User.Grade> userCourses = user.getCourses();
				
				boolean registered = userCourses.containsKey(c);
				boolean toRegister = checkBoxes.get(i).isSelected();
				
				if (!registered && toRegister) {
					userCourses.put(c, User.Grade.NOT_GRADED);
					
				} else if (registered && !toRegister) {
					userCourses.remove(c);
				}
			}
			
			WebTarget userTarget = target.path("users").path(user.getUserName());
			Entity<User> userEntity = Entity.entity(user, MediaType.TEXT_XML);
			userTarget.request(MediaType.TEXT_XML).put(userEntity, User.class);
		}
	}
}
