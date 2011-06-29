package com.onehao.io;

import java.io.File;
import java.io.IOException;

public class FileTest
{
	public static void main(String[] args)
	{
		File file = new File("myfile");
		
		try
		{
			System.out.println(file.createNewFile());
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
