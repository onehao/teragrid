package com.onehao.thread;

/**
 * ���ڳ�Ա������ֲ����������һ�������ǳ�Ա��������ô����̶߳�ͬһ������ĳ�Ա�������в���ʱ�����ǶԸó�Ա�����Ǳ˴�Ӱ��ģ�
 * Ҳ����˵һ���̶߳Գ�Ա�����ĸı��Ӱ�쵽��һ���̣߳���
 * 
 * 
 * ���һ�������Ǿֲ���������ôÿ���̶߳�����һ���þֲ������Ŀ�����һ���̶߳Ըþֲ������ĸı䲻��Ӱ�쵽�������̡߳�
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
	int i; //50�����

	@Override
	public void run()
	{
//		int i = 0; // 100�������ÿ���̶߳������Լ���һ�ݾֲ������Ŀ���
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