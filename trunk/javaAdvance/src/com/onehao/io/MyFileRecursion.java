package com.onehao.io;

import java.io.File;

public class MyFileRecursion
{
	public static void fileTree(File file)
	{
		System.out.println(file.getName());
		if(0 != file.listFiles().length && file.isDirectory())
		{
			System.out.print("\t");
			File[] files = file.listFiles();
			
			for(File f : files)
			{
				if(f.isDirectory())
				{
					fileTree(f);
				}
				
			}
		
		}
	}
	
	public static void main(String[] args)
	{
		File file = new File("bin");
		fileTree(file);
	}
}
