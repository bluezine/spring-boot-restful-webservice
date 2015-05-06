package kr.co.bluezine.repository;

import java.util.List;

import kr.co.bluezine.dao.User;
import kr.co.bluezine.mapper.UserMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("UserRepository")
public class UserRepository {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private UserMapper getMapper() {
		return sqlSessionTemplate.getMapper(UserMapper.class);
	}
	
	public List<User> getUsers() {
		return getMapper().getUsers();
	}
	
	public User getUser(String id) {
		return getMapper().getUser(id);
	}
	
	public void insertUser(User user) {
		getMapper().insertUser(user);
	}
	
	public void updateUser(User user) {
		getMapper().updateUser(user);
	}
	
	public void deleteUser(User user) {
		getMapper().deleteUser(user);
	}
}
