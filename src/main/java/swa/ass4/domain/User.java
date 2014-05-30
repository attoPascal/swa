package swa.ass4.domain;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User implements Comparable<User> {
	public enum Role {
		ADMINISTRATOR, STUDENT, TEACHER;
	}
	
	public enum Grade {
		NOT_GRADED, GRADE_1, GRADE_2, GRADE_3, GRADE_4, GRADE_5;
	}
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private Role role;
	
	private Map<Course, Grade> courses;
	
	public User() {
		this("", "", "", "", null, null);
	}
	
	public User(String firstName, String lastName, String userName, String password, Role role, Map<Course, Grade> grades) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.courses = grades;
	}
	
	public String toString() {
		return firstName + " is a " + role.toString();
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Map<Course, Grade> getCourses() {
		return courses;
	}

	public void setCourses(Map<Course, Grade> grades) {
		this.courses = grades;
	}

	public void addCourse(Course course, Grade grade) {
		courses.put(course, grade);
	}

	@Override
	public int compareTo(User o) {
		return userName.compareTo(o.getUserName());
	}
}
