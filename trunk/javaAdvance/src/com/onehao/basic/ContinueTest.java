package com.onehao.basic;

public class ContinueTest
{
	public static void main(String[] args)
	{
		for(int i = 0; i < 10; i++)
		{
			if(5 == i)
			{
				continue;
			}
					
			System.out.println(i);
		}
	}
}
