package com.onehao.classloader;

public class MyTest
{
	public static void main(String[] args)
	{
		Singleton singleton = Singleton.getInstance();//���þ�̬������������
		
		System.out.println("counter1 = " + singleton.counter1); //1
		System.out.println("counter2 = " + singleton.counter2); //0
	}
}

class Singleton
{
	/*
	 * ���ϵ���ִ��
	 * ����˳��
	 * 1.singleton -> null
	 *   counter1 -> 0
	 *   counter2 -> 0
	 * 2.new Singleton() ����singleton
	 *   ��ʹ�� counter1 -> 1
	 *         counter2 -> 1
	 * 3.û�и�counter1��ֵ
	 * 4.counter2=0; counter2 -> 0      
	 */
	private static Singleton singleton = new Singleton();
	
	public static int counter1;
	
	public static int counter2 = 0;
	
//	private static Singleton singleton = new Singleton();
	
	private Singleton()
	{
		counter1++;
		counter2++;
	}
	
	public static Singleton getInstance()
	{
		return singleton;
	}
}
