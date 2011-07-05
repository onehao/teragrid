package com.onehao.thread;

/**
 * �Ƽ��ķ�ʽ
 * 
 *  **��Ҫʹ��Thread �е� stop����
 * @author onehao
 *
 */
public class StopThreadTest
{
	private MyThread0 r = new MyThread0();
	
	private Thread t = new Thread(r);
	
	public void startThread()
	{
		t.start();
	}
	
	public void stopThread()
	{
		r.stopRunning();
	}
}

class MyThread0 implements Runnable
{
	private boolean flag = true;
	
	public void run()
	{
		while(flag)
		{
			
		}
	}
	
	public void stopRunning()
	{
		flag = false;
	}
}
