package com.onehao.middle.l4;

public class ArrayTest3 {

	public static void main(String[] args) {
		
		Student1[] s = new Student1[100];
		
		for(int i = 0; i< s.length; i++)
		{
			s[i] = new Student1();
			
			s[i].name = i % 2 == 0? "zhangsan" : "lisi";
		}
		
		for(int i = 0; i < s.length; i++)
		{
			System.out.println(s[i].name);
		}
	}
}

class Student1
{
	String name;
}
