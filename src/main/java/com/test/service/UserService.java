package com.test.service;


import com.test.entity.User;
import com.test.entity.UserEntity;

public interface UserService {

	public void createUser();
	UserEntity getUser(Integer id);
	User getUserRepository(Integer id);
	public void testAsync();
}
