package com.onehao.io;

public class Test1
{
	public int compute(int number)
	{
		int result = 1;
		
		for(int i = number; i > 0; i--)
		{
			result *= i;
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		Test1 test = new Test1();
		System.out.println(test.compute(5));
	}
}
