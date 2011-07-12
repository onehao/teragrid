package com.onehao.classloader;

class FinalTest
{
	public static final int x = 6 / 3; //编译时的常量，不会导致类被初始化
	
	static 
	{
		System.out.println("FinalTest static block");
	}
}

public class Test2
{
	public static void main(String[] args)
	{
		System.out.println(FinalTest.x);
	}
}
