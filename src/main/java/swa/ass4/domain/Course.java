package swa.ass4.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Course {
	private int id;
	private String name;
	private String description;
	private User lecturer;
	private Date registrationBegin;
	private Date registrationEnd;
	
	public Course() {
		this(0, null, null, null, null, null);
	}
	
	public Course(int id, String name, String description, User lecturer, Date registrationBegin, Date registrationEnd) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.lecturer = lecturer;
		this.registrationBegin = registrationBegin;
		this.registrationEnd = registrationEnd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getLecturer() {
		return lecturer;
	}

	public void setLecturer(User lecturer) {
		this.lecturer = lecturer;
	}

	public Date getRegistrationBegin() {
		return registrationBegin;
	}

	public void setRegistrationBegin(Date registrationBegin) {
		this.registrationBegin = registrationBegin;
	}

	public Date getRegistrationEnd() {
		return registrationEnd;
	}

	public void setRegistrationEnd(Date registrationEnd) {
		this.registrationEnd = registrationEnd;
	}
}
