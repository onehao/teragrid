package com.onehao.jdk5.autoboxing$unboxing;

/**
 * Integer����һ�����棬���Ỻ�����-128��127֮���������
 * @author onehao
 *
 */
public class BoxTest2
{
	public static void main(String[] args)
	{
		Integer i1 = 100; //������200�Ͳ������
		Integer i2 = 100;
		
		if(i1 == i2)
		{
			System.out.println("i1 == i2");
		}
		else
		{
			System.out.println("i1 != i2");
		}
	}
}
