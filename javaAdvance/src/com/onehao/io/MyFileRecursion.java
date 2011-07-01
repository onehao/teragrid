package com.onehao.io;

import java.io.File;

/**
 * 作业：给定任意一个目录，以树形方式展现出该目录中的所有子目录和文件。
 * 另外，在展现的时候将目录排在上面，文件排在下面。每一层要加上缩进
 * @author onehao
 *
 */
public class MyFileRecursion
{
	public static void fileTree(File file, String sep)
	{
		
		System.out.print(sep);
		//如果是目录
		if(file.isDirectory())
		{
			//打印出根目录， 每调用一次当前节点即视为根目录
			System.out.println(file.getName());
			
			File[] files = file.listFiles();
			
			sep = sep + sep.substring(0, 2);
			
			//先输出目录
			for(int i = 0; i < files.length; i++)
			{
				if(files[i].isDirectory())
				fileTree(files[i],sep);
			}
			
			//后输出文件
			for(int i = 0; i < files.length; i++)
			{
				if(files[i].isFile())
				fileTree(files[i],sep);
			}
		}
		else
		{
			System.out.println(file.getName());
		}
	}
	
	public static void main(String[] args)
	{
		File file = new File("E:\\training myself\\java\\gen");
		fileTree(file, "  ");
		
	}
}
