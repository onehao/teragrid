package com.onehao.basic;

public class PolyTest
{
	public static void main(String[] args)
	{
		Flower rose = new Rose(); //��̬
		rose.sing();
		System.out.println(rose.getClass().getName());
		
	}
}

class Flower
{
	public void sing()
	{
		System.out.println("flower is singing");
	}
}

class Rose extends Flower
{
}
