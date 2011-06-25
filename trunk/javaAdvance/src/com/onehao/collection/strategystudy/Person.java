package com.onehao.collection.strategystudy;
public class Person
{
	@Override
	public String toString()
	{
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	private int id;
	
	private String name;
	
	private int age;

	public void setAge(int age)
	{
		this.age = age;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
