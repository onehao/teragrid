package com.onehao.jdk5.autoboxing$unboxing;

/**
 * Integer类有一个缓存，它会缓存介于-128～127之间的整数。
 * @author onehao
 *
 */
public class BoxTest2
{
	public static void main(String[] args)
	{
		Integer i1 = 100; //都换成200就不相等了
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
