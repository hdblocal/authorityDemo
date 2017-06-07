package com.whir.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/page1")
	public String page1(){
		return "test" ;
	}
	
	@RequestMapping("/page2")
	public String page2(){
		return "test" ;
	}
	
	@RequestMapping("/page3")
	public String page3(){
		return "test" ;
	}
	
	@RequestMapping("/page4")
	public String page4(){
		return "test" ;
	}
	
	@RequestMapping("/page5")
	public String page5(){
		return "test" ;
	}
}
