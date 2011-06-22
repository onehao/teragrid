package com.onehao.collection.map;

import java.util.Comparator;
import java.util.TreeMap;

public class MyHomeWork2
{
	public static void main(String[] args)
	{
		TreeMap map = new TreeMap(new PersonComparator());
		
		Person p1 = new Person("zhangsan", 20);
		Person p2 = new Person("liso", 23);
		Person p3 = new Person("wangwu", 19);
		Person p4 = new Person("zhaoliu", 30);
		
		map.put(p1, p1.firstName);
		map.put(p2, p2.firstName);
		map.put(p3, p3.firstName);
		map.put(p4, p4.firstName);
		
		System.out.println(map);
	}
}

class Person
{
	int  cardId;
	String firstName;
	
	Person(String firstName, int cardId)
	{
		this.firstName = firstName;
		this.cardId = cardId;
	}

	@Override
	public String toString()
	{
		return "Person [cardId=" + cardId + ", firstName=" + firstName + "]";
	}

}

class PersonComparator implements Comparator
{

	@Override
	public int compare(Object o1, Object o2)
	{
		Person p1 = (Person)o1;
		Person p2 = (Person)o2;
		
		return p1.cardId - p2.cardId;
	}
	
}
