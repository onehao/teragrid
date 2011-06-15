package com.onehao.basic;
public class PolyTest2
{
	public static  void main(String[] args)
	{
		/*
		Animal animal = new Cat();
		Animal animal2 = new Animal();

		animal2 = animal;
		animal2.sing();
		*/
		
		/*
		Animal animal = new Cat();
		Animal animal2 = new Animal();

		animal = animal2;
		animal.sing();
		*/

		/*
		Cat cat = new Cat();
		Animal animal = cat;
		animal.sing();
		*/
		
		/*
		Animal animal = new Animal();
		Cat cat = (Cat)animal;
		*/

		//向上类型转换
		Cat cat = new Cat();

		Animal2 animal = cat;

		animal.sing();

		//向下类型转换
		Animal2 a = new Cat();

		Cat c = (Cat)a;

		c.sing();

	}
}

class Animal2
{
	public void sing()
	{
		System.out.println("animal is singing");
	}
}

class Dog2 extends Animal2
{
	public void sing()
	{
		System.out.println("dog is singing");
	}
}

class Cat extends Animal2
{
	public void sing()
	{
		System.out.println("cat is singing");
	}
}
