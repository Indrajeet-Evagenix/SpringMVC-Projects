package com.becoder.dao;

import com.becoder.entity.User;

public interface UserDao {

	public int saveUser(User user);

	public User login(String email, String password);
	
//	public User loginCheck(String email);

}
