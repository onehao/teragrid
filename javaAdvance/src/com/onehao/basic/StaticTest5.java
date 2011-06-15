package com.onehao.basic;

public class StaticTest5
{
	public static void main(String[] args)
	{
		W w = new W();
		w.change();
		
		System.out.println(w.a);
			
		System.out.println(W.a);
	}
}

class W
{
	static int a = 10;

	public static void change()
	{
		a++;
	}
}
