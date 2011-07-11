package com.onehao.network;

/**
 * ���̻߳��������ĵ���
 * 
 * ���ڵ���ģʽ��Singleton����˵�������getInstance()����������Singletonʵ������ܻ����ͬ�����⣬�����ܻ�����������ͬ�Ķ���
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