package com.onehao.basic;

public class People
{
	int age;

	public void change(int i)
	{
		i++;
	}
	
	public void change2(People people)
	{
		people = new People();
		
		people.age++;
	}
	
	public void change3(People p, int i)
	{
		p.age++;
		i++;
	}

	public static void main(String[] args)
	{
		People people = new People();

		int age = people.age;

		System.out.println(age);

		people.change2(people);

		int age2 = people.age;

		System.out.println(age2);
		
		People p3 = new People();
		
		p3.change3(p3, p3.age);
		
		System.out.println(p3.age);
	}


}
