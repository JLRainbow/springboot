package com.test.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.test.entity.UserEntity;
@CacheConfig(cacheNames = "baseCache")
public interface UserMapper {

	@Select("select * from user where id = #{id}")
	@Cacheable
	UserEntity getUser(@Param("id")Integer id);
}
