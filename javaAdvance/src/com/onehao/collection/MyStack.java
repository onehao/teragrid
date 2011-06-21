package com.onehao.collection;

import java.util.LinkedList;

public class MyStack {

	LinkedList list = new LinkedList();
	
	public void push(Object o)
	{
		list.addLast(o);
	}

	public Object pop()
	{
		Object o = list.getLast();
		list.removeLast();
		return o;
	}

	public Object peek()
	{
		return list.getLast();
	}

	public boolean isEmpty()
	{
		return list.isEmpty();
	}
}
