package com.onehao.reflection;

import java.lang.reflect.Method;

public class TestPrivate {

	public static void main(String[] args) throws Exception{
		Private p = new Private();
		
		Class<?> classType = p.getClass();
		
		Method method = classType.getDeclaredMethod("sayHello", 
				new Class[]{String.class});
		
		method.setAccessible(true);//ѹ��java�ķ��ʿ��Ƽ��
	
		String str = (String)method.invoke(p, new Object[]{"onehao"});
		
		System.out.println(str);
	}
}
