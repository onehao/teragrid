package com.onehao.io;

import java.io.File;
import java.io.FilenameFilter;

public class MyFileNameFilterTest
{
	public static void main(String[] args)
	{
		File f = new File("gen");
		
		System.out.println(f.separator);
		System.out.println(f.separatorChar);
		
		File[] files = f.listFiles(new MyFileNameFilter());
		
		for(int i = 0; i < files.length; i ++)
		{
			System.out.println(files[i].getName());
		}
	}
}

class MyFileNameFilter implements FilenameFilter
{
	@Override
	public boolean accept(File dir, String name)
	{
		if(name.endsWith("bak"))
		{
			return true;
		}
		
		if(name.contains("11"))
		{
			return true;
		}

		else
		{
			return false;
		}
	}
}
