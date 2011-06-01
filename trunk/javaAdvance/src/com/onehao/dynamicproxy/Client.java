package com.onehao.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Date;

public class Client {

	public static void main(String[] args) {
		RealSubject realSubject = new RealSubject();
		
		InvocationHandler handler = new DynamicSubject(realSubject);
		
		Class<?> classType = handler.getClass();
		//下面代码一次性生成代理
		
		Subject sub = (Subject)Proxy.newProxyInstance(classType.getClassLoader(),
						realSubject.getClass().getInterfaces(), handler);
		
		sub.request();
		
		System.out.println(sub.getClass());
		
		sub.requestWithParams("onehao", new Date());
	}
}
