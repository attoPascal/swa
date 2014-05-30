package swa.ass4.domain;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	public enum Role {
		ADMINISTRATOR, STUDENT, TEACHER;
	}
	
	public enum Grade {
		GRADE_1, GRADE_2, GRADE_3, GRADE_4, GRADE_5;
	}
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private Role role;
	private Map<Course, Grade> grades;
	
	public User() {
		this("", "", "", "", null, null);
	}
	
	public User(String firstName, String lastName, String userName, String password, Role role, Map<Course, Grade> grades) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.grades = grades;
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

	public Map<Course, Grade> getGrades() {
		return grades;
	}

	public void setGrades(Map<Course, Grade> grades) {
		this.grades = grades;
	}

	public void addGrade(Course course, Grade grade) {
		grades.put(course, grade);
	}
}
