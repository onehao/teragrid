package com.onehao.reflection;

public class OuterClass
{
	public static void world()
	{
		System.out.println("world");
	}
	static class InnerClass
	{
		int a = 10;
		
		void hello()
		{
			System.out.println("hello");
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(InnerClass.class.getName());
	}
}
