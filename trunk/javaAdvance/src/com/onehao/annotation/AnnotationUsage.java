package com.onehao.annotation;

@AnnocationTest("hello")
public class AnnotationUsage {
	
	@AnnocationTest(value="world")
	public void method()
	{
		System.out.println("usage of annotation");
	}
	
	public static void main(String[] args) {
		AnnotationUsage usage = new AnnotationUsage();
		usage.method();
	}
}
