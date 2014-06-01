package swa.ass4.server.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import swa.ass4.domain.Course;
import swa.ass4.domain.User;

public class TestDataDAO implements DAO {
	private static TestDataDAO instance = null;
	
	private HashMap<String, User> users;
	private HashMap<Integer, Course> courses;
	
	private TestDataDAO() {
		initUsers();
		initCourses();
		initGrades();
	}

	public static TestDataDAO getInstance() {
		if (instance == null) {
			instance = new TestDataDAO();
		}
		
		return instance;
	}

	@Override
	public List<User> getUsers() {
		ArrayList<User> list = new ArrayList<>(users.values());
		Collections.sort(list);
		
		return list;
	}

	@Override
	public User getUser(String userName) {
		return users.get(userName);
	}
	
	@Override
	public void addUser(User user) {
		users.put(user.getUserName(), user);
	}

	@Override
	public void updateUser(String userName, User user) {
		if (!user.getUserName().equals(userName)) {
			user.setUserName(userName);
		}
		
		users.put(userName, user);
	}
	
	@Override
	public void deleteUser(String userName) {
		users.remove(userName);
	}
	
	@Override
	public List<Course> getCourses() {
		ArrayList<Course> list = new ArrayList<>(courses.values());
		Collections.sort(list);
		
		return list;
	}
	
	@Override
	public Course getCourse(int id) {
		return courses.get(Integer.valueOf(id));
	}
	
	@Override
	public void addCourse(Course course) {
		courses.put(course.getId(), course);
	}
	
	private void initUsers() {
		users = new HashMap<>();
		
		addUser(new User("Eddard", "Stark", "estark", "wolf", null, User.Role.ADMINISTRATOR, null));
		addUser(new User("Robert", "Baratheon", "rbaratheon", "stag", null, User.Role.ADMINISTRATOR, null));
		addUser(new User("Tywin", "Lannister", "tlannister", "lion", null, User.Role.ADMINISTRATOR, null));
		
		addUser(new User("Aemon", "Targaryen", "atargaryen", "at", null, User.Role.TEACHER, null));
		addUser(new User("Syrio", "Forel", "sforel", "sf", null, User.Role.TEACHER, null));
		addUser(new User("Jorah", "Mormont", "jmormont", "jm", null, User.Role.TEACHER, null));
		addUser(new User("Davos", "Seaworth", "dseaworth", "ds", null, User.Role.TEACHER, null));
		
		addUser(new User("Robb", "Stark", "a1200001", "abc1", "a1200595@unet.univie.ac.at", User.Role.STUDENT, new HashMap<Course, User.Grade>()));
		addUser(new User("Jon", "Snow", "a1200002", "abc2", "a1200595@unet.univie.ac.at", User.Role.STUDENT, new HashMap<Course, User.Grade>()));
		addUser(new User("Sansa", "Stark", "a1200003", "abc3", "a1200595@unet.univie.ac.at", User.Role.STUDENT, new HashMap<Course, User.Grade>()));
		addUser(new User("Arya", "Stark", "a1200004", "abc4", "a1200595@unet.univie.ac.at", User.Role.STUDENT, new HashMap<Course, User.Grade>()));
		addUser(new User("Bran", "Stark", "a1200005", "abc5", "a1200595@unet.univie.ac.at", User.Role.STUDENT, new HashMap<Course, User.Grade>()));
		addUser(new User("Rickon", "Stark", "a1200006", "abc6", "a1200595@unet.univie.ac.at", User.Role.STUDENT, new HashMap<Course, User.Grade>()));
		addUser(new User("Joffrey", "Baratheon", "a1200007", "abc7", "a1200595@unet.univie.ac.at", User.Role.STUDENT, new HashMap<Course, User.Grade>()));
		addUser(new User("Myrcella", "Baratheon", "a1200008", "abc8", "a1200595@unet.univie.ac.at", User.Role.STUDENT, new HashMap<Course, User.Grade>()));
		addUser(new User("Tommen", "Baratheon", "a1200009", "abc9", "a1200595@unet.univie.ac.at", User.Role.STUDENT, new HashMap<Course, User.Grade>()));
	}
	
	private void initCourses() {
		courses = new HashMap<>();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date1;
		Date date2;
		Date date3;
		
		try {
			date1 = df.parse("2014-01-01");
			date2 = df.parse("2014-06-30");
			date3 = df.parse("2014-05-01");
		} catch (ParseException e) {
			date1 = null;
			date2 = null;
			date3 = null;
		}
		
		addCourse(new Course(1, "Ravenry 101", "", getUser("atargaryen"), date1, date2));
		addCourse(new Course(2, "Healing 101", "", getUser("atargaryen"), date1, date2));
		addCourse(new Course(3, "Water Dancing 101", "", getUser("sforel"), date1, date3));
		addCourse(new Course(4, "History of Westeros 101", "", getUser("jmormont"), date1, date2));
		addCourse(new Course(5, "Smuggling 101", "", getUser("dseaworth"), date1, date2));
	}
	
	private void initGrades() {
		// you know nothing, jon snow.
		getUser("a1200002").addCourse(getCourse(1), User.Grade.GRADE_5);
		
		// what do we say to the god of studying? not today.
		getUser("a1200004").addCourse(getCourse(3), User.Grade.GRADE_4);
		
		getUser("a1200001").addCourse(getCourse(2), User.Grade.NOT_GRADED);
		getUser("a1200002").addCourse(getCourse(2), User.Grade.NOT_GRADED);
		getUser("a1200003").addCourse(getCourse(2), User.Grade.NOT_GRADED);
		getUser("a1200004").addCourse(getCourse(2), User.Grade.NOT_GRADED);
		getUser("a1200005").addCourse(getCourse(2), User.Grade.NOT_GRADED);
		getUser("a1200006").addCourse(getCourse(2), User.Grade.NOT_GRADED);
		
		getUser("a1200007").addCourse(getCourse(5), User.Grade.NOT_GRADED);
		getUser("a1200008").addCourse(getCourse(5), User.Grade.NOT_GRADED);
		getUser("a1200009").addCourse(getCourse(5), User.Grade.NOT_GRADED);
	}
}
