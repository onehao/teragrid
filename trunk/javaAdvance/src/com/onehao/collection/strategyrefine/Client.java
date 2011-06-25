package com.onehao.collection.strategyrefine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client
{
	public static void sort(List<Person> list, ISort is)
	{
		is.sort(list);
	}
	public static void main(String[] args)
	{
		List<Person> list = new ArrayList<Person>();
		
		Person p1 = new Person(1, "a1", 23);
		Person p2 = new Person(2, "zhangsan", 44);
		Person p3 = new Person(4, "hello", 66);
		Person p4 = new Person(23, "wangwu", 34);
		Person p5 = new Person(66, "world", 11);
		Person p6 = new Person(12, "welcome", 34);
		Person p7 = new Person(9, "b3", 26);
		Person p8 = new Person(22, "c0", 33);
		Person p9 = new Person(88, "b3", 29);
		Person p10 = new Person(12, "hello", 14);
		Person p11 = new Person(4, "Èý¹úÉ±", 27);
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		list.add(p7);
		list.add(p8);
		list.add(p9);
		list.add(p10);
		list.add(p11);
		
		
		System.out.println(" ------ sort by id ASC -------");
		
		
		sort(list, new SortById());
		
		for(Iterator<Person> iter = list.iterator(); iter.hasNext();)
		{
			System.out.println(iter.next());
		}
		
		System.out.println(" ------ sort by age ASC -------");
		
		
		sort(list, new SortByAge());
		
		for(Iterator<Person> iter = list.iterator(); iter.hasNext();)
		{
			System.out.println(iter.next());
		}
		
		System.out.println(" ------ sort by name ASC -------");
		
		sort(list, new SortByName());
		
		for(Iterator<Person> iter = list.iterator(); iter.hasNext();)
		{
			System.out.println(iter.next());
		}
		
	}
}
