package com.onehao.basic.lesson3;
/**
 * 
 * @author onehao
 *
 *15. instanceof： 判断某个对象是否是某个类的实例。语法形式：
 *	引用名 instanceof 类名（接口名），返回一个boolean值。
 *	16. People people = new Man();
 *	17. System.out.println(people instanceof People); 
 *  //结果为true，因为Man是People的子类，根据继承，子类就是父类，因此Man也可以看作是People的实例。
 */

public class InstanceofTest
{
	public static void main(String[] args)
	{
		People people = new Man();

		System.out.println(people instanceof People);
	}
}

class People
{

}

class Man extends People
{

}
