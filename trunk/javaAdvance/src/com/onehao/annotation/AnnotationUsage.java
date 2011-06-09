package com.onehao.annotation;

@AnnotationTest(value2 = EnumTest.Welcome)
public class AnnotationUsage {
	
	@AnnotationTest(value1 = {"world","hello"},value2 = EnumTest.World)
	public void method()
	{
		System.out.println("usage of annotation");
	}
	
	public static void main(String[] args) {
		AnnotationUsage usage = new AnnotationUsage();
		usage.method();
	}
}
