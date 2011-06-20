package com.onehao.middle.l4;

public class ArrayTest4 {

	public static void main(String[] args) {
		
		int[][] i = new int[2][3];
		
		System.out.println(i instanceof Object);

		System.out.println(i[0] instanceof int[]);
		
		System.out.println(i[0] instanceof int[]);
		
		for(int k = 0; k < 2; k++)
		{
			
			for(int l = 0, j = 0; l < i[0].length; l++)
			{
				j++;
				i[k][l] = 2 * j;
			}
		}
	}
}
