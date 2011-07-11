package com.onehao.network;

/**
 * 不会出现多线程问题
 * @author onehao
 *
 */
public class Singleton
{
	private static Singleton singleton = new Singleton();
	
	private Singleton()
	{
		
	}
	
	public static Singleton getInstance()
	{
		return singleton;
	}
}
