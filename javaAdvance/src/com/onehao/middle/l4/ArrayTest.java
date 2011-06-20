package com.onehao.middle.l4;

public class ArrayTest {

	public static void main(String[] args) {
		int[] a = new int[4]; //数组时一个对象 或者int a[] = new int[4];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		
		System.out.println(a[2]);
		
		int[] b = {1, 2, 3, 4};
		
		System.out.println(b[2]);
		
		int[] c = new int[]{1, 2, 3, 4};
		System.out.println(c[2]);
		
		int[] d = new int[100];
		
		for(int i = 0; i < d.length; i++)
		{
			d[i] = i + 1;
		}
		for (int i = 0; i < d.length; i++)
		{
			System.out.println(d[i]);
		}
		
		int[] e = new int[4];
		
		System.out.println(e[0]);//看做成员变量， 有默认值
		
		
		int[] f = {1, 2, 3};
		int[] g = {1, 2, 3};
		System.out.println(f.equals(g));
		
	}
	
}
