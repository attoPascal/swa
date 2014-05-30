package swa.ass4.server.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import swa.ass4.domain.User;

public class TestDataDAO implements DAO {
	private static TestDataDAO instance = null;
	
	private List<User> users;
	
	private TestDataDAO() {
		initUsers();
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
	
	private void initUsers() {
		users = new ArrayList<User>();
		
		users.add(new User("Eddard", "Stark", "estark", "wolf", User.Role.ADMINISTRATOR));
		users.add(new User("Robert", "Baratheon", "rbaratheon", "stag", User.Role.ADMINISTRATOR));
		users.add(new User("Tywin", "Lannister", "tlannister", "lion", User.Role.ADMINISTRATOR));
		
		users.add(new User("Aemon", "Targaryen", "atargaryen", "at", User.Role.TEACHER));
		users.add(new User("Syrio", "Forel", "sforel", "sf", User.Role.TEACHER));
		users.add(new User("Jorah", "Mormont", "jmormont", "jm", User.Role.TEACHER));
		users.add(new User("Davos", "Seaworth", "dseaworth", "ds", User.Role.TEACHER));
		
		users.add(new User("Robb", "Stark", "a1200001", "abc01", User.Role.STUDENT));
		users.add(new User("Jon", "Snow", "a1200002", "abc02", User.Role.STUDENT));
		users.add(new User("Sansa", "Stark", "a1200003", "abc03", User.Role.STUDENT));
		users.add(new User("Arya", "Stark", "a1200004", "abc04", User.Role.STUDENT));
		users.add(new User("Bran", "Stark", "a1200005", "abc05", User.Role.STUDENT));
		users.add(new User("Rickon", "Stark", "a1200006", "abc06", User.Role.STUDENT));
		users.add(new User("Joffrey", "Baratheon", "a1200007", "abc07", User.Role.STUDENT));
		users.add(new User("Myrcella", "Baratheon", "a1200008", "abc08", User.Role.STUDENT));
		users.add(new User("Tommen", "Baratheon", "a1200009", "abc09", User.Role.STUDENT));
		users.add(new User("Drogon", "Targaryen", "a1200010", "abc10", User.Role.STUDENT));
		users.add(new User("Viserion", "Targaryen", "a1200011", "abc11", User.Role.STUDENT));
		users.add(new User("Rhaegal", "Targaryen", "a1200012", "abc12", User.Role.STUDENT));
	}
}
