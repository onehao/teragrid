package com.onehao.thread;

public class ThreadTest2
{
	public static void main(String[] args)
	{
		Thread t1 = new Thread(new MyThread());
		t1.start();
		
		Thread t2 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				for(int i = 1000; i < 1100; i++)
				{
					System.out.println(i);
				}
			}
		});
		t2.start();
	}
}

class MyThread implements Runnable
{
	@Override
	public void run()
	{
		for(int i = 0; i < 100; i++)
		{
			System.out.println("hello :" + i);
		}
	}
}

class MyThread2 implements Runnable
{
	@Override
	public void run()
	{
			
	}
}
