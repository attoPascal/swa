package swa.ass4.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import swa.ass4.domain.Course;
import swa.ass4.domain.User;
import swa.ass4.server.data.DAO;
import swa.ass4.server.data.TestDataDAO;

@Path("/courses")
public class CourseResource {
	@Context
    UriInfo url;
	
    @Context
    Request request;
    
    String name;
    
    private DAO dao;
    
    public CourseResource() {
    	dao = TestDataDAO.getInstance();
    }
    
    @GET
    @Produces("text/xml")
    public List<Course> getCourses() {
    	return dao.getCourses();
    }
    
    @POST
	@Consumes("text/xml")
	@Produces("text/xml")
    public Course addCourse(Course course) {
    	dao.addCourse(course);
    	return dao.getCourse(course.getId());
    }
	
	@GET
	@Path("/lecturers/{username}")
    @Produces("text/xml")
	public List<Course> getLecturerCourses(@PathParam("username") String userName) {
		List<Course> courses = dao.getCourses();
		List<Course> lecturerCourses = new ArrayList<>();
		
		for (Course c : courses) {
			if (c.getLecturer().getUserName().equals(userName)) {
				lecturerCourses.add(c);
			}
		}
		
		return lecturerCourses;
	}
	
	@GET
	@Path("/students/{courseid}")
	@Produces("text/xml")
	public List<User> getStudents(@PathParam("courseid") int courseId) {
		Course course = dao.getCourse(courseId);
		
		List<User> users = dao.getUsers();
		List<User> courseStudents = new ArrayList<>();
		
		for (User u : users) {
			Map<Course, User.Grade> courses = u.getCourses();
			if (courses != null && courses.containsKey(course)) {
				courseStudents.add(u);
			}
		}
		
		return courseStudents;
	}
	
	/*@PUT
	@Path("/{username}")
	@Consumes("text/plain")
	@Produces("text/plain")
	public String setPassword(@PathParam("username") String userName, String password) {
		User user = dao.getUser(userName);
		user.setPassword(password);
		
		return "Password changed";
	}
	
	@DELETE
	@Path("/{username}")
	public void deleteUser(@PathParam("username") String userName) {
		dao.deleteUser(userName);
	}*/
}
