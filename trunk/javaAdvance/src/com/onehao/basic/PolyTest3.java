package com.onehao.basic;

public class PolyTest3
{
	public static void main(String[] args)
	{
		//Fruit f = new Pear();
		//f.run();
		
		//Pear p = (Pear)f;
		//p.run();
		
		//Fruit f = new Pear();
		//f.grow();

		Fruit2 f = new Pear();

		Pear p = (Pear)f;
		
		p.grow();

	}
}

class Fruit2
{
	public void run()
	{
		System.out.println("fruit is running");
	}
}

class Pear extends Fruit2
{
	public void run()
	{
		System.out.println("pear is running");
	}

	public void grow()
	{
		System.out.println("pear is growing");
	}
}
