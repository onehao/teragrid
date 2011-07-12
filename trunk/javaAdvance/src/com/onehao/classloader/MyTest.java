package com.onehao.classloader;

public class MyTest
{
	public static void main(String[] args)
	{
		Singleton singleton = Singleton.getInstance();
		
		System.out.println("counter1 = " + singleton.counter1);
		System.out.println("counter2 = " + singleton.counter2);
	}
}

class Singleton
{
	private static Singleton singleton = new Singleton();
	
	public static int counter1;
	
	public static int counter2 = 0;
	
//	private static Singleton singleton = new Singleton();
	
	private Singleton()
	{
		counter1++;
		counter2++;
	}
	
	public static Singleton getInstance()
	{
		return singleton;
	}
}
