package com.onehao.basic;

public class PersonTest
{
	public static void main(String[] args)
	{
		Person2 person = new Person2(50);

		System.out.println(person.age);
	}
}

class Person2
{
	int age;

	public Person2(int i)
	{
		age = i;
	}
}
