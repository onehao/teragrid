package com.onehao.basic;

public class StaticTest3
{
	public static void main(String[] args)
	{
		M m = new N();

		m.output();
		
		O o = new P1();
		
		o.output();
		
		P1.output();
	}
}

class M
{
	public void output()
	{
		System.out.println("M");
	}
}

class N extends M
{
//	public static void output()
//	{
//		System.out.println("N");
//	}
}

class O
{
	public static void output()
	{
		System.out.println(" print from class O");
	}
}


class P1 extends O
{
	
}







