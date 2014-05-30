package swa.ass4.client.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import swa.ass4.client.gui.CreateCoursePanel;
import swa.ass4.domain.Course;
import swa.ass4.domain.User;

public class CreateCourse implements ActionListener {
	private User user;
	private WebTarget target;

	public CreateCourse(User user, WebTarget target) {
		this.user = user;
		this.target = target;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CreateCoursePanel panel = new CreateCoursePanel();
		int result = JOptionPane.showConfirmDialog(null, panel, "Create Course", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {
			WebTarget coursesTarget = target.path("courses");
			
			Course newCourse = panel.getCourse();
			newCourse.setLecturer(user);
			
			Entity<Course> courseEntity = Entity.entity(newCourse, MediaType.TEXT_XML);
			Course response = coursesTarget.request(MediaType.TEXT_XML).post(courseEntity, Course.class);

			System.out.println("Course " + response.getName() + " created");
		}
	}
}
