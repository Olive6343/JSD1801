package com.ldq.springmvcdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class HelloController {

	@RequestMapping
	public String hello(){
		return "hello";
	}
}
