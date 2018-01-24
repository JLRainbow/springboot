package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.entity.User;
import com.test.entity.UserEntity;
import com.test.mapper.UserMapper;
import com.test.repository.UserRepository;
import com.test.service.UserService;
import com.test01.entity.User01Entity;
import com.test01.mapper.User01Mapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private User01Mapper user01Mapper;

	@Transactional
	public void createUser() {
		// 从数据库u_user表查询数据
		User01Entity user01Entity = user01Mapper.getUser(1);
		user01Mapper.addUser("zhangsan");
		int i = 2 / 0;
		String sql = "insert into user values(null,?,?)";
		jdbcTemplate.update(sql, user01Entity.getNickname(), 18);
		// 控制事务测试
	}

	public UserEntity getUser(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.getUser(id);
	}

	public User getUserRepository(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	/**
	 * 启动类加上@EnableAsync ,需要执行异步方法上加入@Async
	 */
	@Async
	public void testAsync() {
		System.out.println("service==2");
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("i" + i);
		}
		System.out.println("service==3");
	}

}
