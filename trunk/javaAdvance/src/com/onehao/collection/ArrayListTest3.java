package com.onehao.collection;

import java.util.ArrayList;

public class ArrayListTest3 {

	public static void main(String[] args) {

		ArrayList list = new ArrayList();

		list.add(3);
		list.add(new Integer(4));
		list.add(new Integer(5));
		list.add(new Integer(6));

		Integer in = (Integer) list.get(0);

		System.out.println(in);

		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			int value = ((Integer) list.get(i)).intValue();

			sum += value;
		}

		System.out.println(sum);
	}
}
