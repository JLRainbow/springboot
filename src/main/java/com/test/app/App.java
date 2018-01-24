package com.test.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.test.config.DBConfig;
import com.test.config.DBConfig1;
@ComponentScan(basePackages={"com.test.*","com.test01*"})
@EnableAutoConfiguration
//@MapperScan(basePackages="com.test.mapper")

@EnableJpaRepositories(basePackages = "com.test.repository")
@EntityScan(basePackages = "com.test.entity")
@EnableConfigurationProperties(value = { DBConfig.class, DBConfig1.class })
@EnableCaching //开启缓存注解
// @EnableScheduling //开启定时注解
@EnableAsync //开启异步调用注解
public class App {
	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}
}
