package swa.ass4.server.data;

import java.util.List;

import swa.ass4.domain.User;

public interface DAO {
	public List<User> getUsers();
	public User getUser(String userName);
}
