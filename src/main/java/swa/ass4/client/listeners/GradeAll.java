package swa.ass4.client.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import swa.ass4.client.gui.CourseSelectPanel;
import swa.ass4.client.gui.GradeAllPanel;
import swa.ass4.domain.Course;
import swa.ass4.domain.User;

public class GradeAll implements ActionListener {
	private User user;
	private WebTarget target;
	
	public GradeAll(User user, WebTarget target) {
		this.user = user;
		this.target = target;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		WebTarget coursesTarget = target.path("courses");
		WebTarget lecturerTarget = coursesTarget.path("lecturers").path(user.getUserName());
		List<Course> courses = lecturerTarget.request(MediaType.TEXT_XML).get(new GenericType<List<Course>>() {});
		
		CourseSelectPanel panel = new CourseSelectPanel(courses);
		int result = JOptionPane.showConfirmDialog(null, panel, "Select Course", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (result == JOptionPane.OK_OPTION) {
			Course course = panel.getCourse();
			
			WebTarget studentsTarget = coursesTarget.path("students").path(Integer.toString(course.getId()));
			List<User> students = studentsTarget.request(MediaType.TEXT_XML).get(new GenericType<List<User>>() {});
			
			GradeAllPanel panel2 = new GradeAllPanel(course, students);
			int result2 = JOptionPane.showConfirmDialog(null, panel2, course.getName() + ": Grade All", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			
			if (result2 == JOptionPane.OK_OPTION) {
				List<JComboBox<User.Grade>> grades = panel2.getGrades();
				
				for (int i = 0; i < students.size(); i++) {
					User u = students.get(i);
					WebTarget userTarget = target.path("users").path(u.getUserName());
					
					JComboBox<User.Grade> jcb = grades.get(i);
					User.Grade g = jcb.getItemAt(jcb.getSelectedIndex());
					
					Map<Course, User.Grade> studentCourses = u.getCourses();
					if (!studentCourses.get(course).equals(g)) {
						studentCourses.put(course, g);
						
						// TODO Mail Notification
						
						Entity<User> userEntity = Entity.entity(u, MediaType.TEXT_XML);
						User response = userTarget.request(MediaType.TEXT_XML).put(userEntity, User.class);
						
						System.out.println(response.getFirstName() + ": " + response.getCourses().get(course));
					}
				}
			}
		}
	}

}
