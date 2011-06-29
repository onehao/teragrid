package com.onehao.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileTest7
{
	public static void main(String[] args) throws IOException
	{
		File file = new File("gen/hello");
		
		String[] names = file.list(new FilenameFilter()
		{
			@Override
			public boolean accept(File dir, String name)
			{
				if(name.endsWith(".java"))
				{
					return true;
				}
				return false;
			}
		});
		
		for(String name : names)
		{
			System.out.println(name);
		}
	}
}
