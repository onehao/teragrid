package com.onehao.jdk5.generics;

import java.util.List;
import java.util.ArrayList;

public class ArrayListTest
{
	public static void main(String[] args)
	{
		List list = new ArrayList();
		
		list.add("String");
		list.add(new Integer(2));
		list.add(new Boolean(false));
		
		String str = (String)list.get(0);
		Integer in = (Integer)list.get(1);
		String b = (String)list.get(2); //运行时抛出异常
		
		
	}
}
