package swa.ass4.server.users;

public abstract class User {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	
	public User(String firstName, String lastName, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserName() {
		return userName;
	}

	public boolean checkPassword(String password) {
		if (password.equals(this.password)) {
			return true;
		} else {
			return false;
		}
	}
	
	// TODO check?
	public void setPassword(String password) {
		this.password = password;
	}
}
