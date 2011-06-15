package com.onehao.basic;

public class ParamTest3
{
	public void change(Person4 person, Person4 person2)
	{
		person.name = "lisi";
		person2.name = "wangwu";
	}

	public static void main(String[] args)
	{
		Person4 person = new Person4();
		person.name = "zhangsan";

		Person4 person2 = person;
//		Person4 person2 = new Person4();

		ParamTest3 test = new ParamTest3();

		test.change(person, person2);

		System.out.println(person.name);

	}


}


class Person4
{
	String name;
}




