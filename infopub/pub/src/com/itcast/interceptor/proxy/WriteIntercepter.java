package com.itcast.interceptor.proxy;

public class WriteIntercepter {
	/**
	 * 第一个拦截器方法
	 */
	public void methodAaa(){
		System.out.println("-------调用第一个拦截器方法methodAaa----");
	}
	
	/**
	 * 第二个拦截器方法
	 */
	public void methodBbb(){
		System.out.println("-------调用第二个拦截器方法methodBbb----");
	}
	
}
