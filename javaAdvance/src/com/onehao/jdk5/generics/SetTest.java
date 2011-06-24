package com.onehao.jdk5.generics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest
{
	public static void main(String[] args)
	{
		Set<String>	 set = new HashSet<String>();
		
		set.add("aa");
		set.add("bb");
		set.add("cc");
		
		for(Iterator<String> iter = set.iterator(); iter.hasNext();)
		{
			String value = iter.next();
			System.out.println(value);
		}
		
		
		System.out.println("----------------");
		
		Set<People> set2 = new HashSet<People>();
		
		set2.add(new People("zhangsan", 20, "beijing"));
		set2.add(new People("lisi", 30, "shanghai"));
		set2.add(new People("wangwu",40, "tianjin"));
		
		for(Iterator<People> iter = set2.iterator(); iter.hasNext();)
		{
			People people = iter.next();
			System.out.println(people);
		}
	}
}

class People
{
	private String name;
	
	@Override
	public String toString()
	{
		return "People [name=" + name + ", age=" + age + ", address=" + address
				+ "]";
	}

	private int age;
	
	private String address;
	
	public People(String name, int age, String address)
	{
		this.name = name;
		this.age = age;
		this.address = address;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
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
		People other = (People) obj;
		if (address == null)
		{
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
