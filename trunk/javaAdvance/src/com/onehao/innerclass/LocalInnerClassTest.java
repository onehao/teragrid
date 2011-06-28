package com.onehao.innerclass;

/**
 * �����ھֲ��ڲ����з����ⲿ��ĳ�Ա������
 * �﷨Ϊ��OuterClass.this.a;
 * 
 * ������
 * 
 * @author onehao
 *
 */
class LocalInner
{
	public void doSomething()
	{
		final int a = 4;
		class Inner3
		{
			public void test()
			{
				System.out.println("hello world");
				System.out.println(a);
			}
		}
		
		new Inner3().test();
	}
}

public class LocalInnerClassTest
{
	public static void main(String[] args)
	{
		LocalInner localInner = new LocalInner();
		localInner.doSomething();
	}
}
