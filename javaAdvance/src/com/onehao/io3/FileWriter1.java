package com.onehao.io3;

import java.io.FileWriter;

public class FileWriter1
{
	public static void main(String[] args) throws Exception
	{
		String str = "hello world welcome onehao";
		
		char[] buffer = new char[str.length()];
		
		str.getChars(0, str.length(), buffer, 0);
		
		FileWriter f = new FileWriter("gen/file2.txt");
	
		for(int i = 0; i < buffer.length; i++)
		{
			f.write(buffer[i]);
		}
		
		f.close();
	}
}
