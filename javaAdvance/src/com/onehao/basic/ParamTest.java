package com.onehao.basic;

public class ParamTest
{
	public static void main(String[] args)
	{
		Person3 person = new Person3();

		person.change(person);

		int age = person.age;

		System.out.println(age);

		System.out.println("--------------------------");

		int i = 10;

		person.change2(i);

		System.out.println(i);
	}
}

class Person3
{
	int age = 20;

	public void change(Person3 person)
	{
		person = new Person3();
		
		person.age = 30;
	}

	public void change2(int age)
	{
		age = 40;
	}
}
