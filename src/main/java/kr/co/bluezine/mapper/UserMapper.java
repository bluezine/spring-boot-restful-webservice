package kr.co.bluezine.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.bluezine.dao.User;


public interface UserMapper {
	@Select("SELECT * FROM USER")
	List<User> getUsers();
	
	@Select("SELECT * FROM USER WHERE ID=#{id}")
	User getUser(String id);
	
	@Insert("INSERT INTO USER (ID, NAME) VALUES (#{id}, #{name})")
	void insertUser(User user);
	
	@Update("UPDATE USER SET NAME=#{name} WHERE ID=#{id}")
	void updateUser(User user);
	
	@Delete("DELETE FROM USER WHERE ID=#{id}")
	void deleteUser(User user);
}
