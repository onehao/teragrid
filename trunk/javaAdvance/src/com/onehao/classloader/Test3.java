package com.onehao.classloader;

import java.util.Random;

class FinalTest2
{
	public static final int x = new Random().nextInt(100); //不是编译时可以确定的
	
	static 
	{
		System.out.println("FinalTest2 static block");
	}
}

public class Test3
{
	public static void main(String[] args)
	{
		System.out.println(FinalTest2.x);
	}
}
