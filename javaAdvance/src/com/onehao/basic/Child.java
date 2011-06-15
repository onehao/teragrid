package com.onehao.basic;

public class Child extends Parent
{
	public Child()
	{
		super(1);
		System.out.println("child");
//		super(1);//must be the first in a method
	}

	public static void main(String[] args)
	{
		Child child = new Child();
		
//		Parent parent = new Parent();
	}
}

class Parent
{
	public Parent(int i)
	{
		System.out.println("parent");
	}

	/*
	public Parent()
	{
		System.out.println("no args parent");
	}
	*/
}
