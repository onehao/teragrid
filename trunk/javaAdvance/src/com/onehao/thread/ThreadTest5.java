package com.onehao.thread;

/**
 * synchronized块，写法： synchronized(object) { } 表示线程在执行的时候会对object对象上锁。
 * 
 * 
 * synchronized方法是一种粗粒度的并发控制，某一时刻，只能有一个线程执行该synchronized方法;
 * synchronized块则是一种细粒度的并发控制，只会将块中的代码同步，
 * 位于方法内、synchronized块之外的代码是可以被多个线程同时访问到的。
 * 
 * 
 * @author onehao
 * 
 */
public class ThreadTest5
{
	public static void main(String[] args)
	{
		Example2 e = new Example2();

		TheThread3 t1 = new TheThread3(e);
		TheThread4 t2 = new TheThread4(e);

		t1.start();
		t2.start();
	}
}

class Example2
{
	// private Object object = new Object();
	public void execute()
	{
		synchronized (this)
		{
			for (int i = 0; i < 20; i++)
			{
				try
				{
					Thread.sleep((long) Math.random() * 1000);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("hello: " + i);
			}
		}

	}

	public void execute2()
	{
		synchronized (this)
		{
			for (int i = 0; i < 20; i++)
			{
				try
				{
					Thread.sleep((long) Math.random() * 1000);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("world: " + i);
			}
		}

	}
}

class TheThread3 extends Thread
{
	private Example2 example;

	public TheThread3(Example2 example)
	{
		this.example = example;
	}

	@Override
	public void run()
	{
		this.example.execute();
	}
}

class TheThread4 extends Thread
{
	private Example2 example;

	public TheThread4(Example2 example)
	{
		this.example = example;
	}

	@Override
	public void run()
	{
		this.example.execute2();
	}
}