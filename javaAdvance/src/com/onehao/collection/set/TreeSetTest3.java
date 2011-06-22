package com.onehao.collection.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest3
{
	public static void main(String[] args)
	{
		TreeSet set = new TreeSet(new MyComparator());
		
		set.add("C");
		set.add("A");
		set.add("B");
		set.add("E");
		set.add("a");
		set.add("F");
		set.add("D");
		
		for(Iterator iter = set.iterator(); iter.hasNext();)
		{
			String value = (String)iter.next();
			
			System.out.println(value);
		}
	}
}


class MyComparator implements Comparator
{

	@Override
	public int compare(Object o1, Object o2)
	{
		String s1 = (String)o1;
		String s2 = (String)o2;
		
		return s2.compareTo(s1);
	}
	
}
