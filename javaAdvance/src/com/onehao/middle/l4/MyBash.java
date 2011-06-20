package com.onehao.middle.l4;

public class MyBash {

	public static void main(String[] args) {
		int pid = 2105746, p = 0;
		int[] a = {118976, 
				168138, 
				463246,
				250068,
				627024,
				2105746,
				1241538,
				925816};
		
		for(int i=0; i<a.length; i++)
		{
			if(pid == a[i]) p = i;
		}
		
		for(int i=p; i<a.length; i++)
		{
			System.out.println(a[i]);
		}
	}
	
	int a = ((3>5)?3:5);
	
}
