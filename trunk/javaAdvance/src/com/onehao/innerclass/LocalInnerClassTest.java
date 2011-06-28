package com.onehao.innerclass;

/**
 * 若想在局部内部类中访问外部类的成员变量，
 * 语法为：OuterClass.this.a;
 * 
 * 不常用
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
