package com.onehao.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestPrivate2 {

	public static void main(String[] args) throws Exception {
		Private2 p = new Private2();
		
		Class<?> classType = p.getClass();
		
		Field f = classType.getDeclaredField("name");
		
		f.setAccessible(true);
		
		f.set(p, "onehao");
		
		Method m = classType.getDeclaredMethod("getName", new Class[]{});
		
		String s = (String)m.invoke(p, new Object[]{});
		
		System.out.println(s);
		
	}
}
