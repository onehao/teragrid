package com.onehao.basic;

public class FinalTest3
{
	public static void main(String[] args)
	{
		People2 people = new People2();
//		people.age = 20;
		
//		people.address = new Address();
		
		people.address.name = "shanghai";
		
	}
}

class People2
{
	final int age = 10;
	final Address address = new Address();
}

class Address
{
	String name = "beijing";
}

