package com.onehao.collection.strategystudy;

import java.util.List;

public class Environment
{
	private SortInterface sortInterface;
	
	public Environment(SortInterface sortInterface)
	{
		
	}
	
	public Environment()
	{
		
	}

	public void setSortInterface(SortInterface sortInterface)
	{
		this.sortInterface = sortInterface;
	}
	
	public void sort(List<Person> list)
	{
		sortInterface.sort(list);
	}
}
