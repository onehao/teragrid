package com.onehao.thread;

/**
 * 关于成员变量与局部变量：如果一个变量是成员变量，那么多个线程对同一个对象的成员变量进行操作时，他们对该成员变量是彼此影响的（
 * 也就是说一个线程对成员变量的改变会影响到另一个线程）。
 * 
 * 
 * 如果一个变量是局部变量，那么每个线程都会有一个该局部变量的拷贝，一个线程对该局部变量的改变不会影响到其他的线程。
 * 
 * @author onehao
 * 
 */
public class ThreadTest3
{
	public static void main(String[] args)
	{
		Runnable r = new HelloThread();

		Thread t1 = new Thread(r);
		
//		r = new HelloThread();
		
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}
}

class HelloThread implements Runnable
{
	int i; //50行输出

	@Override
	public void run()
	{
//		int i = 0; // 100行输出，每个线程都会有自己的一份局部变量的拷贝
		while (true)
		{
			System.out.println("number :" + i++);
			try
			{
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (50 == i)
			{
				break;
			}
		}
	}
}