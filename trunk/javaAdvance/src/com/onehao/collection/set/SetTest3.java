package com.onehao.collection.set;

import java.util.HashSet;

/**
 * 如果我们重写equals方法，那么也要重写hashCode方法，反之亦然。
 * @author onehao
 *
 *
 *2. 关于Object类的equals方法的特点
	a) 自反性：x.equals(x)应该返回true
	b) 对称性：x.equals(y)为true，那么y.equals(x)也为true。
	c) 传递性：x.equals(y)为 true并且y.equals(z)为true，那么x.equals(z)也应该为true。
	d) 一致性：x.equals(y)的第一次调用为true，那么x.equals(y)的第二次、第三次、第n次调用也应该为true，
	前提条件是在比较之间没有修改x也没有修改y。
	e) 对于非空引用x，x.equals(null)返回false。
	3. 关于Object类的hashCode()方法的特点：
	a) 在Java应用的一次执行过程当中，对于同一个对象的hashCode方法的多次调用，他们应该返回同样的值（前提是该对象的信息没有发生变化）。
	b) 对于两个对象来说，如果使用equals方法比较返回true，那么这两个对象的hashCode值一定是相同的。
	c) 对于两个对象来说，如果使用equals方法比较返回false，那么这两个对象的hashCode值不要求一定不同（可以相同，可以不同），
	但是如果不同则可以提高应用的性能。
	d) 对于Object类来说，不同的Object对象的hashCode值是不同的（Object类的hashCode值表示的是对象的地址）。
 */
public class SetTest3
{
	public static void main(String[] args)
	{
		HashSet set = new HashSet();
		
		Student s1 = new Student("zhangsan");
		Student s2 = new Student("zhangsan");
		
		set.add(s1);
		set.add(s2);
		
		System.out.println(set);
	}
}

class Student
{
	String name;
	public Student(String name)
	{
		this.name = name;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
//	@Override
//	public int hashCode()
//	{
//		return this.name.hashCode();
//	}
//	
//	public boolean equals(Object obj)
//	{
//		if(this == obj)
//		{
//			return true;
//		}
//		
//		if(null != obj && obj instanceof Student)
//		{
//			Student s = (Student)obj;
//			
//			if(name.equals(s.name))
//			{
//				return true;
//			}
//		}
//		
//		return false;
//	}
	
	
	
}
