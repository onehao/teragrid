package com.onehao.jdk5.$enum;
public class ColorTest
{
	public static void main(String[] args)
	{
		Color myColor = Color.White;
		
		System.out.println(myColor);
		
		System.out.println(" ---------------- ");
		
		for(Color color : Color.values())
		{
			System.out.println(color);
		}
	}
}
