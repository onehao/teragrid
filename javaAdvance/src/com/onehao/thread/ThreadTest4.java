package com.onehao.thread;

/**
 * 
 * “对象”上锁
 * 
 * 如果一个对象有多个synchronized方法，某一时刻某个线程已经进入到了某个synchronized方法，
 * 那么在该方法没有执行完毕前，其他线程是无法访问该对象的任何synchronized方法的。
 * 
 * @author onehao
 * @since 2011-07-05
 * 
 */
public class ThreadTest4
{
	public static void main(String[] args)
	{
		Example example = new Example();

		Thread t1 = new TheThread(example);
		Thread t2 = new TheThread2(example);

		t1.start();
		t2.start();
	}
}

class Example
{
	public synchronized void execute()
	{
		for (int i = 0; i < 20; i++)
		{
			try
			{
				Thread.sleep((long)Math.random() * 1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("hello: " + i);
		}
	}

	public synchronized void execute2()
	{
		for (int i = 0; i < 20; i++)
		{
			try
			{
				Thread.sleep((long)Math.random() * 1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("world: " + i);
		}
	}
}

class TheThread extends Thread
{
	private Example example;

	public TheThread(Example example)
	{
		this.example = example;
	}

	@Override
	public void run()
	{
		this.example.execute();
	}
}

class TheThread2 extends Thread
{
	private Example example;

	public TheThread2(Example example)
	{
		this.example = example;
	}

	@Override
	public void run()
	{
		this.example.execute2();
	}
}
