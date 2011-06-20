package com.onehao.collection;

import java.util.ArrayList;

/**
 * @author onehao
 *
 */
public class ArrayListTest5 {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		
		list.add(new Point(2, 3));
		list.add(new Point(2, 2));
		list.add(new Point(4, 4));
		
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));;
		}
		
		System.out.println(list);
		
	}
}

/**
 * 
 * @author onehao
 *
 */

class Point
{
	int x;
	
	/**
	 * @return return coordinate of axis of x and y
	 */
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	int y;
	
	Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
