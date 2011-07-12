package com.onehao.classloader;

public class MyTest
{
	public static void main(String[] args)
	{
		Singleton singleton = Singleton.getInstance();//调用静态方法，记载类
		
		System.out.println("counter1 = " + singleton.counter1); //1
		System.out.println("counter2 = " + singleton.counter2); //0
	}
}

class Singleton
{
	/*
	 * 从上到下执行
	 * 加载顺序：
	 * 1.singleton -> null
	 *   counter1 -> 0
	 *   counter2 -> 0
	 * 2.new Singleton() 付给singleton
	 *   这使得 counter1 -> 1
	 *         counter2 -> 1
	 * 3.没有给counter1赋值
	 * 4.counter2=0; counter2 -> 0      
	 */
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
