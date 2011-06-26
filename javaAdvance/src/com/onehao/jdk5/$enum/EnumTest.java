package com.onehao.jdk5.$enum;

public class EnumTest
{
	public static void doOp(OpConstant opConstant)
	{
		switch(opConstant)
		{
		case TURN_LEFT:
			System.out.println("向左转");
			break;
			
		case TURN_RIGHT:
			System.out.println("向右转");
			break;
			
		case SHOOT:
			System.out.println("射击");
		}
	}
	
	
	public static void main(String[] args)
	{
		doOp(OpConstant.SHOOT);
		
		for(OpConstant op : OpConstant.values())
		{
			doOp(op);
		}
	}
}

enum OpConstant
{
	TURN_LEFT, TURN_RIGHT, SHOOT
}
