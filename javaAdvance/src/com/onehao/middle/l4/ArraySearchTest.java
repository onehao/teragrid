package com.onehao.middle.l4;

public class ArraySearchTest {

	public static int search(int[] array, int value)
	{
		for(int i = 0; i < array.length; i++)
		{
			if(value == array[i])
			{
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		int[] a = new int[]{1, 5, 6, 7, 10, 3, 9};
		
		int value = 9;
		
		int index = search(a, value);
		
		System.out.println(index);
	}
}
