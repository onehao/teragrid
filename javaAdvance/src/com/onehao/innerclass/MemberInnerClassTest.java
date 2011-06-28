package com.onehao.innerclass;

/**
 * member inner classes
 * 
 * 成员内部类（member inner class）：可以访问外部类的静态与非静态的方法与成员变量。
 * 生成成员内部类对象的方式为：
 * OuterClass.InnerClass inner = new OuterClass().new InnerClass();
 * 若想在局部内部类中访问外部类的成员变量，语法为：OuterClass.this.a;
 * 
 * 
 * Defined in an enclosing class without using the static modifier
 * Like instance variables
 * Can access all members of the enclosing class
 * Create an instance within the enclosing classthis.newInnerclass();
 * Create an instance out of the enclosing class(new Outerclass()).new Innerclass();
 * Access members of the enclosing class within inner classesOuterclass.this.member
 * 
 * @author onehao
 *
 */
class MemberInner
{
	private int a = 4;
	
	public class Inner2
	{
		private int a = 5;
		public void doSomething()
		{
			System.out.println("hello world");
			System.out.println(a); // out 5
			System.out.println(this.a); //out 5
			System.out.println(MemberInner.this.a); //out 4
			
		}
	}
	
	public void method()
	{
		Inner2 inner = this.new Inner2();
	}
}

public class MemberInnerClassTest
{
	public static void main(String[] args)
	{
		MemberInner.Inner2 inner = (new MemberInner()).new Inner2();
		inner.doSomething();
	}
}
