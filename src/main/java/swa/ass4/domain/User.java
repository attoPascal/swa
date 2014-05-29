package swa.ass4.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	public enum Role {
		ADMINISTRATOR, STUDENT, TEACHER;
	}
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private Role role;
	
	public User() {
		this("", "", "", "", null);
	}
	
	public User(String firstName, String lastName, String userName, String password, Role role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.role = role;
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
}
