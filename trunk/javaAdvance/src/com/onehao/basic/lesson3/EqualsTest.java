package com.onehao.basic.lesson3;

/**
 * 
 * @author onehao
 *
 * 18. 相等性的比较（==）
 *	1） 对于原生数据类型来说，比较的是左右两边的值是否相等。
 *	2） 对于引用类型来说，比较左右两边的引用是否指向同一个对象，或者说左右两边的引用地址是否相同。
 *
 */

public class EqualsTest
{
	public static void main(String[] args)
	{
		Student2 s1 = new Student2("zhangsan");
		Student2 s2 = new Student2("zhangsan");

		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));		
	}
}

class Student2
{
	String name;

	public Student2(String name)
	{
		this.name = name;
	}
	
	public boolean equals(Object anObject)
	{
		if(this == anObject)
		{
			return true;
		}

		if(anObject instanceof Student2)
		{
			Student2 student = (Student2)anObject;
			
			if(student.name.equals(this.name))
			{
				return true;
			}
		}

		return false;
	}

}
