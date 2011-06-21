package com.onehao.collection;

import java.util.LinkedList;

public class LinkedListTest1 {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.add("F");
		list.add("B");
		list.add("C");
		list.add("A");
		list.add("E");
		
		
		list.addLast("Z");
		list.addFirst("O");

		list.add(1, "A2");
		
		System.out.println("最初的集合：" + list);
		
		list.remove("F");
		list.remove(2);
		
		System.out.println("变化后的集合: " + list);
		
		Object value = list.get(2);
		list.set(2, (String)value + "changed");
		
		System.out.println("最后的集合" + list);
	}
}
