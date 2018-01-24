package com.test01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test01.entity.User01Entity;
import com.test01.mapper.User01Mapper;
import com.test01.service.User01Service;
@Service
public class User01ServiceImpl implements User01Service{
	@Autowired
	private User01Mapper user01Mapper;

	public User01Entity getUser(Integer id) {
		// TODO Auto-generated method stub
		return user01Mapper.getUser(id);
	}

}
