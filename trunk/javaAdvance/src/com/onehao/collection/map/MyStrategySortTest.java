package com.onehao.collection.map;

/**
 * 代码还有问题， set加不进去数据
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyStrategySortTest
{
	public static void main(String[] args)
	{
		Student s1 = new Student(1, "zhangsan", 20);
		Student s2 = new Student(2, "lisi", 23);
		Student s3 = new Student(3, "wangwu", 19);
		Student s4 = new Student(4, "zhaoliu", 25);
		Student s5 = new Student(2,"dalisi", 24);
		Student s6 = new Student(4, "xiaozhaoliu", 17);
		
		Set set = new TreeSet(new SortById());
		
		
		set.add(s1);
		System.out.println(set.contains(s2));
		System.out.println(set.remove(s2));
		System.out.println(set.add(s2));
		System.out.println(set.add(s3));
		set.add(s4);
		
		System.out.println(set.size());
		
//		List<Student> list = new ArrayList<Student>();
//		list.add(s1);
//		list.add(s2);
//		list.add(s3);
//		list.add(s4);
//		list.add(s5);
//		list.add(s6);
//		
//		System.out.println(list.size());
//		
//		Set set = new TreeSet(new SortById());
//		
//		for(Iterator iter = list.iterator(); iter.hasNext();)
//		{
//			set.add((Student)iter.next());
//			System.out.println("------");
//		}
		
		System.out.println(set.size());
//		
//		
//		System.out.println(set.contains(s2));
//		
//		for(Iterator iter = set.iterator(); iter.hasNext();)
//		{
//			Student student = (Student)iter.next();
//			System.out.println(student);
//			System.out.println("---------");
//		}
	}
}

class Student
{
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof Student))
		{
			return false;
		}
		Student other = (Student) obj;
		if (age != other.age)
		{
			return false;
		}
		if (id != other.id)
		{
			return false;
		}
		if (name == null)
		{
			if (other.name != null)
			{
				return false;
			}
		} else if (!name.equals(other.name))
		{
			return false;
		}
		return true;
	}

	Student(int id, String name, int age)
	{
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	private int id;
	
	@Override
	public String toString()
	{
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	private String name;
	
	private int age;
}

class SortById implements Comparator
{

	@Override
	public int compare(Object o1, Object o2)
	{
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		
		if(s1.getId() == s2.getId())
			return s1.getAge() - s2.getAge();
		else
			return s2.getId() - s2.getId();
	}
	
}

class SortByAge implements Comparator
{

	@Override
	public int compare(Object o1, Object o2)
	{
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		
		if(s1.getAge() == s2.getAge())
			return s2.getId() - s2.getId();
		else
			return s1.getAge() - s2.getAge();
	}
}

class SortByName implements Comparator
{

	@Override
	public int compare(Object o1, Object o2)
	{
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		return s1.getName().compareTo(s2.getName());
	}
	
}
