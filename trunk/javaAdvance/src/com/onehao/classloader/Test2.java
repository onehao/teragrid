package com.onehao.classloader;

class FinalTest
{
	public static final int x = 6 / 3; //����ʱ�ĳ��������ᵼ���౻��ʼ��
	
	static 
	{
		System.out.println("FinalTest static block");
	}
}

public class Test2
{
	public static void main(String[] args)
	{
		System.out.println(FinalTest.x);
	}
}
