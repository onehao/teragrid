package com.onehao.thread2;

public class DecreaseThread extends Thread
{
	private Sample sample;
	
	public DecreaseThread(Sample sample)
	{
		this.sample = sample;
	}
	
	@Override
	public void run()
	{
		for(int i = 0; i < 20; i++)
		{
			try
			{
				Thread.sleep((long)(Math.random() * 1000));
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sample.decrease();
		}
	}
}
