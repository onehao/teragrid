package com.onehao.basic.lesson3;

import java.lang.reflect.Method;

public class B {

	
	public static void main(String[] args) throws Exception{
		
		Class c = Class.forName("A");
		
		Method m = c.getMethod("outa", new Class[]{});
		
		m.invoke(c.newInstance(), new Object[]{});
	}
}
