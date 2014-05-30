package swa.ass4.server.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import swa.ass4.domain.Course;
import swa.ass4.domain.User;

public class TestDataDAO implements DAO {
	private static TestDataDAO instance = null;
	
	private List<User> users;
	private List<Course> courses;
	
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
		return users;
	}

	@Override
	public User getUser(String userName) {
		for (User u : users) {
			if (u.getUserName().equals(userName)) {
				return u;
			}
		}
		
		return new User();
	}
	
	@Override
	public void addUser(User user) {
		users.add(user);
	}

	@Override
	public void updateUser(String userName, User user) {
		ListIterator<User> it = users.listIterator();
		
		while (it.hasNext()) {
			User u = it.next();
			
			if (u.getUserName().equals(userName)) {
				it.set(user);
			}
		}
	}
	
	@Override
	public void deleteUser(String userName) {
		Iterator<User> it = users.iterator();
		while (it.hasNext()) {
		    if (it.next().getUserName().equals(userName)) {
		        it.remove();
		    }
		}
	}
	
	@Override
	public List<Course> getCourses() {
		return courses;
	}
	
	@Override
	public Course getCourse(int id) {
		for (Course c : courses) {
			if (c.getId() == id) {
				return c;
			}
		}
		
		return new Course();
	}
	
	@Override
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	private void initUsers() {
		users = new ArrayList<User>();
		
		users.add(new User("Eddard", "Stark", "estark", "wolf", User.Role.ADMINISTRATOR, null));
		users.add(new User("Robert", "Baratheon", "rbaratheon", "stag", User.Role.ADMINISTRATOR, null));
		users.add(new User("Tywin", "Lannister", "tlannister", "lion", User.Role.ADMINISTRATOR, null));
		
		users.add(new User("Aemon", "Targaryen", "atargaryen", "at", User.Role.TEACHER, null));
		users.add(new User("Syrio", "Forel", "sforel", "sf", User.Role.TEACHER, null));
		users.add(new User("Jorah", "Mormont", "jmormont", "jm", User.Role.TEACHER, null));
		users.add(new User("Davos", "Seaworth", "dseaworth", "ds", User.Role.TEACHER, null));
		
		users.add(new User("Robb", "Stark", "a1200001", "abc1", User.Role.STUDENT, new HashMap<Course, User.Grade>()));
		users.add(new User("Jon", "Snow", "a1200002", "abc2", User.Role.STUDENT, new HashMap<Course, User.Grade>()));
		users.add(new User("Sansa", "Stark", "a1200003", "abc3", User.Role.STUDENT, new HashMap<Course, User.Grade>()));
		users.add(new User("Arya", "Stark", "a1200004", "abc4", User.Role.STUDENT, new HashMap<Course, User.Grade>()));
		users.add(new User("Bran", "Stark", "a1200005", "abc5", User.Role.STUDENT, new HashMap<Course, User.Grade>()));
		users.add(new User("Rickon", "Stark", "a1200006", "abc6", User.Role.STUDENT, new HashMap<Course, User.Grade>()));
		users.add(new User("Joffrey", "Baratheon", "a1200007", "abc7", User.Role.STUDENT, new HashMap<Course, User.Grade>()));
		users.add(new User("Myrcella", "Baratheon", "a1200008", "abc8", User.Role.STUDENT, new HashMap<Course, User.Grade>()));
		users.add(new User("Tommen", "Baratheon", "a1200009", "abc9", User.Role.STUDENT, new HashMap<Course, User.Grade>()));
	}
	
	private void initCourses() {
		courses = new ArrayList<Course>();
		
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
		
		courses.add(new Course(1, "Ravenry 101", "", getUser("atargaryen"), date1, date2));
		courses.add(new Course(2, "Healing 101", "", getUser("atargaryen"), date1, date2));
		courses.add(new Course(3, "Water Dancing 101", "", getUser("sforel"), date1, date3));
		courses.add(new Course(4, "History of Westeros 101", "", getUser("jmormont"), date1, date2));
		courses.add(new Course(5, "Smuggling 101", "", getUser("dseaworth"), date1, date2));
	}
	
	private void initGrades() {
		// you know nothing, jon snow.
		getUser("a1200002").addGrade(getCourse(1), User.Grade.GRADE_5);
		
		// what do we say to the god of studying? not today.
		getUser("a1200004").addGrade(getCourse(3), User.Grade.GRADE_4);
	}
}
