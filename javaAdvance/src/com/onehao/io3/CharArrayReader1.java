package com.onehao.io3;

import java.io.CharArrayReader;

public class CharArrayReader1
{
	public static void main(String[] args) throws Exception
	{
		String tem = "abcdefg";
		
		char[] ch = new char[tem.length()];
		
		tem.getChars(0, tem.length(), ch, 0);
		
		CharArrayReader input = new CharArrayReader(ch);
		
		int i;
		
		while(-1 != (i = input.read()))
		{
			System.out.println((char)i);
		}
	}
}
