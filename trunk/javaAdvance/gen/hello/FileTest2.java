package com.onehao.io;

import java.io.File;
import java.io.IOException;

public class FileTest2
{
	public static void main(String[] args) throws IOException
	{
		File file = new File("./gen");
		
		File file2 = new File(file,"hello.txt");
		
		file2.createNewFile();
		
		File file3 = new File("./gen", "h");
		file3.createNewFile();
	}
}
