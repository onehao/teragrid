package com.onehao.annotation;

public class MyDocumentedTest {

	@MyDocumentedAnnotation(hello = "welcome")
	public void method()
	{
		System.out.println("hello world!");
	}
}
