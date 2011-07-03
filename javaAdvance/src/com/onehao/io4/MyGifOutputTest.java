package com.onehao.io4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyGifOutputTest
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fis = new FileInputStream("src/com/onehao/io4/rational.gif");
		
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		
		FileOutputStream fos = new FileOutputStream("gen/rational_bak.gif");
		
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		byte[] b = new byte[1024];
		int length;
		while(-1 != (length = bis.read(b, 0, 1024)))
		{
			bos.write(b, 0, length);
		}
		
		bos.close();
		
		bis.close();
		
	}
}
