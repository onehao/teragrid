package com.onehao.thread;

/**
 * 16. synchronized�ؼ��֣���synchronized�ؼ�������һ��������ʱ�򣬸÷�������ͬ�������� 
 * 
 * 17.
 * Java�е�ÿ��������һ������lock�����߽�����������monitor����������ĳ�������synchronized����ʱ��
 * ��ʾ���ö���������
 * ��ʱ�����κ��̶߳��޷���ȥ���ʸ�synchronized������
 * ��ֱ��֮ǰ���Ǹ��߳�ִ�з�����Ϻ󣨻������׳����쳣������ô���ö�������ͷŵ���
 * �����̲߳��п�����ȥ���ʸ�synchronized������
 * 
 * @author onehao
 * @since 2011-07-05
 * 
 */
public class FetchMoney
{
	public static void main(String[] args)
	{
		Bank bank = new Bank();

		Thread t1 = new MoneyThread(bank); // ��̨
		Thread t2 = new MoneyThread(bank); // ATM

		t1.start();
		t2.start();
	}
}

class Bank
{
	private int money = 1000;

	public synchronized int getMoney(int number)
	{
		if (number < 0)
		{
			return -1;
		} else if (number > money)
		{
			return -2;
		} else if (money < 0)
		{
			return -3;
		} else
		{
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			money -= number;

			System.out.println("left money: " + money);
			return number;
		}
	}
}

class MoneyThread extends Thread
{
	private Bank bank;

	public MoneyThread(Bank bank)
	{
		this.bank = bank;
	}

	@Override
	public void run()
	{
		System.out.println(bank.getMoney(800));
	}
}
