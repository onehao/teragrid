package com.onehao.io;

import java.io.File;
import java.io.IOException;

public class FileTest6
{
	public static void main(String[] args) throws IOException
	{
		File file = new File("gen/hello");
		
		String[] names = file.list();
		
		for(String name : names)
		{
			if(name.endsWith(".java"))
			{
				System.out.println(name);
			}
		}
	}
}
