package com.onehao.network;

/**
 * 多线程会出现问题的单例
 * 
 * 对于单例模式（Singleton）来说，如果在getInstance()方法中生成Singleton实例则可能会产生同步问题，即可能会生成两个不同的对象。
 * @author onehao
 *
 */
public class Singleton2
{
	private static Singleton2 singleton ;
	
	private Singleton2()
	{
		
	}
	
	public static Singleton2 getInstance()
	{
		if(null == singleton)
		{
			try
			{
				Thread.sleep((long)Math.random() * 4000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			singleton = new Singleton2();
		}
		return singleton;
	}
	
	public static void main(String[] args)
	{
		new MyThread().start();
		new MyThread().start();
	}
}

class MyThread extends Thread
{
	@Override
	public void run()
	{
		System.out.println(Singleton2.getInstance());
	}
}