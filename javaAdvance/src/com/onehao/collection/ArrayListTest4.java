package com.onehao.collection;

import java.util.ArrayList;

public class ArrayListTest4 {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(new Integer(3));
		list.add(new Integer(4));
		list.add(new Integer(5));
		list.add(new Integer(6));
		list.add(new Integer(6));
		
		
		System.out.println(list.indexOf(6));
		/*
		 * ���ܽ�Object[]ת��ΪInteger[]
		 */
		
		
		Object[] a = list.toArray();
		
		for(int i = 0; i < a.length; i++ )
		{
			System.out.println((Integer)a[i]);
		}
		
	}
}
