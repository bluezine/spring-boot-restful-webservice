package kr.co.bluezine.service;

import java.util.List;

import kr.co.bluezine.dao.User;

public interface UserService {
	List<User> getUsers();
	User getUser(String id);
	void insertUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
}
