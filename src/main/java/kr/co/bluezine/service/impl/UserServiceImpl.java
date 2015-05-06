package kr.co.bluezine.service.impl;

import java.util.List;

import kr.co.bluezine.dao.User;
import kr.co.bluezine.repository.UserRepository;
import kr.co.bluezine.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("UserRepository")
	private UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		return userRepository.getUsers();
	}

	@Override
	public User getUser(String id) {
		return userRepository.getUser(id);
	}

	@Override
	public void insertUser(User user) {
		userRepository.insertUser(user);
	}

	@Override
	public void updateUser(User user) {
		userRepository.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		userRepository.deleteUser(user);
		
	}
}
