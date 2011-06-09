package com.onehao.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MyReflection {

	public static void main(String[] args) throws Exception {
		
		MyTest myTest = new MyTest();
		
		Class<MyTest> c = MyTest.class;
		
		Method method = c.getDeclaredMethod("output", new Class[]{});
		
		if(method.isAnnotationPresent(MyAnnotation.class))
		{
			method.invoke(myTest, new Object[]{});
			
			MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
			
			String hello = myAnnotation.hello();
			String world = myAnnotation.world();
			
			System.out.println(hello + ", " + world);
		}
		
		Annotation[] annotations = method.getAnnotations();
		for(Annotation a : annotations)
		{
			System.out.println(a.annotationType().getName());
		}
		
		//onehao test
		if(c.isAnnotationPresent(MyAnnotation.class))
		{
			MyAnnotation ma = c.getAnnotation(MyAnnotation.class);
			
			String hello = ma.hello();
			String world = ma.world();
			
			System.out.println(hello + ", " + world);
		}
		Annotation[] cAnnotation = c.getAnnotations();
		for(Annotation ca : cAnnotation)
		{
			System.out.println(ca.annotationType().getName());
		}
	}
}
