package com.onehao.annotation;

import java.lang.reflect.Method;

public class OnehaoAnnotationReflectionTest {
	
	@OnehaoAnnotation
	public void output1()
	{
		System.out.println("hello world output1");
	}
	
	@OnehaoAnnotation
	public void output2()
	{
		System.out.println("hello world output2");
	}
	
	public void notoutput1()
	{
		System.out.println("hello world notoutput1");
	}
	
	@OnehaoAnnotation
	public void output3()
	{
		System.out.println("hello world output3");
	}
	
	public void notoutput2()
	{
		System.out.println("hello world notoutput2");
	}
	
	public void notoutput3()
	{
		System.out.println("hello world notoutput3");
	}

	public static void main(String[] args) throws Exception {
		
		OnehaoAnnotationReflectionTest oaft = new OnehaoAnnotationReflectionTest();
		
		Class<OnehaoAnnotationReflectionTest> c = OnehaoAnnotationReflectionTest.class;
		
		Method[] methods = c.getMethods();
		
		for(Method m : methods)
		{
			if(m.isAnnotationPresent(OnehaoAnnotation.class))
			{
				m.invoke(oaft, new Object[]{});
			}
		}
	}
}
