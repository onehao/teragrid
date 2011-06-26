package com.onehao.jdk5.$enum;

public class EnumTest
{
	public static void doOp(OpConstant opConstant)
	{
		switch(opConstant)
		{
		case TURN_LEFT:
			System.out.println("����ת");
			break;
			
		case TURN_RIGHT:
			System.out.println("����ת");
			break;
			
		case SHOOT:
			System.out.println("���");
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
