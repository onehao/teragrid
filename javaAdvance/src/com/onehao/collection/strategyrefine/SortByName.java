package com.onehao.collection.strategyrefine;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByName implements ISort
{

	@Override
	public void sort(List<Person> list)
	{
		Collections.sort(list, new SorByNameComparator());
	}
}

class SorByNameComparator implements Comparator<Person>
{
	@Override
	public int compare(Person p1, Person p2)
	{
		String name1 = p1.getName();
		String name2 = p2.getName();
		
		if(name1.equals(name2))
		{
			return p1.getAge() - p2.getAge();
		}
		
		return name1.compareTo(name2);
	}
}