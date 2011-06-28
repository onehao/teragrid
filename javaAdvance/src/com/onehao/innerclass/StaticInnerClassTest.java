package com.onehao.innerclass;

/**
 * static inner classes (also called nested classes)
 * 
 * 静态内部类（static inner class）：只能访问外部类的静态成员变量与静态方法，
 * 生成静态内部类对象的方式为：
 * OuterClass.InnerClass inner = new OuterClass.InnerClass();
 * 
 * @author onehao
 *
 */
class StaticInner
{
	private static int a = 4;
	
	public static class Inner
	{
		public void test()
		{
			System.out.println(a);
		}
	}
	
}
public class StaticInnerClassTest
{
	public static void main(String[] args)
	{
		StaticInner.Inner inner = new StaticInner.Inner();
	
		inner.test();
	}
}
