package com.test.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * 全局异常拦截
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(RuntimeException.class) //拦截所有运行时异常
	@ResponseBody //拦截返回的结果是json格式
	public Map<String, Object> exceptionHandler(){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "500");
		result.put("msg", "系统错误，请稍后再试...");
		return result;
		
	}
}
