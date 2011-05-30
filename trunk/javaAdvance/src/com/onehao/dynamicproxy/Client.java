package com.onehao.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		RealSubject realSubject = new RealSubject();
		
		InvocationHandler handler = new DynamicSubject(realSubject);
		
		Class<?> classType = handler.getClass();
		//�������һ�������ɴ���
		
		Subject sub = (Subject)Proxy.newProxyInstance(classType.getClassLoader(),
		realSubject.getClass().getInterfaces(), handler);
		
		sub.request();
		
		System.out.println(sub.getClass());
	}
}
