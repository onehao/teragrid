package com.onehao.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.onehao.reflection.OuterClass.InnerClass;

public class ReflectInnerStaticClass
{
	public static void main(String[] args) throws Exception
	{
		Class clazz = OuterClass.class;
	
		Method m = clazz.getMethod("world", new Class[]{});
		
		m.setAccessible(true);
		
		m.invoke(clazz, null);
		
		Class innerClazz = Class.forName("com.onehao.reflection.OuterClass$InnerClass");
		
		Method m2 = innerClazz.getDeclaredMethod("hello", new Class[]{});
		
		InnerClass icinstance = (InnerClass)innerClazz.newInstance();
		
		m2.invoke(innerClazz.newInstance(), null);
		
		Field f = innerClazz.getDeclaredField("a");
		
		System.out.println(f.getInt(icinstance));
	}
	
}

