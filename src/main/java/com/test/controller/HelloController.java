package com.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "success";

	}
	/**
	 * 
	 *方法：测试全局捕获异常
	 *创建时间：2017年12月20日
	 *创建者：jial
	 */
	@RequestMapping("/exceptionTest")
	public String exceptionTest() {
		int i = 4 / 0;
		return "success";

	}
}
