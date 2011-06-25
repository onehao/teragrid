package com.onehao.jdk5.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ListGenericFoo<T extends List>
{
	private T[] fooArray;

	public T[] getFooArray()
	{
		return fooArray;
	}

	public void setFooArray(T[] fooArray)
	{
		this.fooArray = fooArray;
	}
	
	public static void main(String[] args)
	{
		ListGenericFoo<LinkedList> foo1 = new ListGenericFoo<LinkedList>();
		ListGenericFoo<ArrayList> foo2 = new ListGenericFoo<ArrayList>();
		
		LinkedList[] linkedList = new LinkedList[10];
		
		foo1.setFooArray(linkedList);
		
		ArrayList[] arrayList = new ArrayList[10];
		
		foo2.setFooArray(arrayList);
		
		
//		ListGenericFoo<HashMap> foo3 = new ListGenericFoo<HashMap>();
		/*Bound mismatch: The type HashMap is not a valid substitute 
		 * for the bounded parameter <T extends List> of the type 
		 * ListGenericFoo<T>
		 */
		
		
		
	}
}
