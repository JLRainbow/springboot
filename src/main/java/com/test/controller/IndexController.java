package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.entity.User;
import com.test.entity.UserEntity;
import com.test.service.UserService;
import com.test01.entity.User01Entity;
import com.test01.service.User01Service;

@RequestMapping("/index")
@Controller
public class IndexController {
	
	private static Logger log = Logger.getLogger(IndexController.class);
	
	@Autowired
	private CacheManager cacheManager;
	
	@Autowired
	private UserService userSerivce;
	@Autowired
	private User01Service user01Serivce;

	/**
	 * 
	 *方法：集成freemarker测试
	 *创建时间：2017年12月21日
	 *创建者：jial
	 */
	@RequestMapping("/index")
	public String index(ModelMap map,Integer id){
		map.addAttribute("name", "xiaoming");
		map.addAttribute("sex", 1);//1.男  0.女  其他
		
		List<String> userList = new ArrayList<String>();
		userList.add("张三");
		userList.add("李四");
		userList.add("王五");
		map.addAttribute("userList", userList);
		
		UserEntity user = userSerivce.getUser(id);
		map.addAttribute("user", user);
		return "index";
		
	}
	/**
	 * 
	 *方法：集成jdbctemplate测试
	 *创建时间：2017年12月21日
	 *创建者：jial
	 */
	@ResponseBody
	@RequestMapping("/createUser")
	public String createUser(){
		userSerivce.createUser();
		return "addSuccess";
		
	}
	/**
	 * 
	 *方法：集成mybatis测试
	 *创建时间：2017年12月21日
	 *创建者：jial
	 */
	@ResponseBody
	@RequestMapping("/getUser")
	public UserEntity getUser(Integer id){
		//多数据源测试，查询test01数据库u_user表
		User01Entity user01Entity = user01Serivce.getUser(id);
		System.out.println(user01Entity.toString());
		
		return userSerivce.getUser(id);
	}
	
	/**
	 * 
	 *方法：集成jpa测试
	 *创建时间：2017年12月21日
	 *创建者：jial
	 */
	@ResponseBody
	@RequestMapping("/getUserRepository")
	public User getUserRepository(Integer id){
		return userSerivce.getUserRepository(id);
	}
	/**
	 * 
	 *方法：log日志测试
	 *创建时间：2017年12月25日
	 *创建者：jial
	 */
	@ResponseBody
	@RequestMapping("/log")
	public String log(){
		log.info("test log....");
		return "success";
	}
	/**
	 * 
	 *方法：清除缓存
	 *创建时间：2017年12月25日
	 *创建者：jial
	 */
	@ResponseBody
	@RequestMapping("/removeCache")
	public String removeCache(){
		cacheManager.getCache("baseCache").clear();
		return "success";
	}
	/**
	 * 
	 *方法：开启异步调用
	 *创建时间：2017年12月25日
	 *创建者：jial
	 */
	@ResponseBody
	@RequestMapping("/testAsync")
	public String testAsync(){
		System.out.println("controller==1");
		userSerivce.testAsync();
		System.out.println("controller==4");
		return "success";
	}
	/**
	 * 
	 *方法：读取配置文件的自定义参数
	 *创建时间：2017年12月25日
	 *创建者：jial
	 */
	@Value("${name}")
	private String name;
	@ResponseBody
	@RequestMapping("/getValue")
	public String getValue() {
		return name;
	}
}
