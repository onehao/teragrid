package com.onehao.thread;

/**
 * 16. synchronized关键字：当synchronized关键字修饰一个方法的时候，该方法叫做同步方法。 
 * 
 * 17.
 * Java中的每个对象都有一个锁（lock）或者叫做监视器（monitor），当访问某个对象的synchronized方法时，
 * 表示将该对象上锁，
 * 此时其他任何线程都无法再去访问该synchronized方法了
 * ，直到之前的那个线程执行方法完毕后（或者是抛出了异常），那么将该对象的锁释放掉，
 * 其他线程才有可能再去访问该synchronized方法。
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

		Thread t1 = new MoneyThread(bank); // 柜台
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
