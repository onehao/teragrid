package com.onehao.middle.l4;

public class ArrayCopy {

	public static void main(String[] args) {
		
		int[] a = new int[]{1, 2, 3, 4};
		
		int[] b = new int[4];
		
		int length = a.length;
		
		System.arraycopy(a, 0, b, 0, length);
		
		for(int i = 0; i < length; i++)
		{
			System.out.println(b[i]);
		}
	}
}
