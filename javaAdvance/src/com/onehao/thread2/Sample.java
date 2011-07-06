package com.onehao.thread2;

public class Sample
{
	private int number;
	
	public synchronized void increase()
	{
		while(0 != number)
		{
			try
			{
				wait();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		number++;
		
		System.out.println(number);
		
		notify();
	}
	
	public synchronized void decrease()
	{
		while(0 == number)
		{
			try
			{
				wait();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		number--;
		
		System.out.println(number);
		
		notify();
	}
}
