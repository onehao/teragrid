package com.onehao.io;

import java.io.File;

public class FileTest3
{
	public static void main(String[] args)
	{
		File file = new File("./gen/hello");//./gen/hello/xzy ʱgen��hello�������
		file.mkdir();
		
		File file2 = new File("./gen/hello/h1/h2/h3");
		file2.mkdirs();
		
		System.out.println(file.isDirectory());
	}
}
