package com.onehao.basic;

import java.awt.Point;

public class ParamTest4 {
	public void changePoint(Point point)
	{
		point.x = 3;
		point.y = 4;
	}

	public static void main(String[] args) {
		
		ParamTest4 pt = new ParamTest4();
		
		Point point = new Point();
		
		pt.changePoint(point);
		
		System.out.println(point.x);
		System.out.println(point.y);
	}
}

class point
{
	int x;
	int y;
}
