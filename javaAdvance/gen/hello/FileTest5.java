package com.onehao.io;

import java.io.File;
import java.io.IOException;

public class FileTest5
{
	public static void main(String[] args) throws IOException
	{
		File file = new File("gen/fordelete");
		
		file.createNewFile();
		
		file.delete();
	}
}
