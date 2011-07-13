package com.onehao.classloader;

public class Dog
{
	public Dog()
	{
		System.out.println("Dog is loaded by: " + this.getClass().getClassLoader());
	}
}
