package com.onehao.jdk5.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest
{
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<String>();
		
//		List list = new ArrayList();
//		list.add("String");
//		list.add(new Integer(2));
//		list.add(new Boolean(false));
//		
//		String str = (String)list.get(0);
//		Integer in = (Integer)list.get(1);
//		String b = (String)list.get(2); //运行时抛出异常
//		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		for(int i = 0; i < list.size(); i++)
		{
			String value = list.get(i);
			System.out.println(value);
		}
		
		System.out.println(" ============");
		
		for(Iterator<String> iter = list.iterator();iter.hasNext();)
		{
			String value = iter.next();
			System.out.println(value);
		}
	}
}
