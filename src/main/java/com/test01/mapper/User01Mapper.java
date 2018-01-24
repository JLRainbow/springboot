package com.test01.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.test01.entity.User01Entity;

public interface User01Mapper {

	@Select("SELECT id,nickname,email,pswd,DATE_FORMAT(create_time,'%Y-%m-%d %H:%i:%s') createTime,DATE_FORMAT(last_login_time,'%Y-%m-%d %H:%i:%s') lastLoginTime,status FROM `u_user` where id = #{id}")
	User01Entity getUser(@Param("id")Integer id);
	@Insert("insert into u_user set nickname = #{nickname}")
	void addUser(@Param("nickname")String nickname);
}
