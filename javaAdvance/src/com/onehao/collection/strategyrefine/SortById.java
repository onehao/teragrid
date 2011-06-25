package com.onehao.collection.strategyrefine;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortById implements ISort
{

	@Override
	public void sort(List<Person> list)
	{
		Comparator c = new SortByIdComaparator();
		Collections.sort(list, c);
	}
}

class SortByIdComaparator implements Comparator<Person>
{

	@Override
	public int compare(Person p1, Person p2)
	{
		int id1 = p1.getId();
		int id2 = p2.getId();
		
		return id1 - id2;
	}
}
