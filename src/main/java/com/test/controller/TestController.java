package com.test.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @RestController 相当于在Controller的每个方法 加上@ResponseBody，所有请求返回json格式
 * 
 * @EnableAutoConfiguration 作用在于让springboot 根据应用所声明的依赖对spring框架进行自动配置
 */
@RequestMapping("/test")
@RestController
// @EnableAutoConfiguration
public class TestController {

	@RequestMapping("/hello")
	public String hello() {
		return "success";

	}

	// public static void main(String[] args) {
	// // 表示为启动类 开始运行
	// SpringApplication.run(TestController.class, args);
	// }
}
