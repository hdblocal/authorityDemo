package com.whir.springmvc.controller;

/**
 * 基类 所有控制器的基类
 * 并且常用的公用方法
 * @author Administrator
 *
 */
public class BaseController {

	/**
	 * 统一获取post参数的方法
	 */
	public void post(){
		
	}
	
	/**
	 * 
	 * 统一获取get参数的方法
	 */
	public void get(){
		
	}
	
	/**
	 * 封装json返回值，主要用于js ajax和后端交互返回格式
	 * json: {
		 * 		  code:状态码 默认200
		 * 		  msg:简单提示信息
		 * 		  data:数据区
		 *        req_id:请求id
	 *        }
	 */
	public void renderJSON(){
		
	}
}
