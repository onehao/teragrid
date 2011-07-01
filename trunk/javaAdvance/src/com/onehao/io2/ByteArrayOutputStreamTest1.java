package com.onehao.io2;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayOutputStreamTest1
{
	public static void main(String[] args) throws IOException
	{
		ByteArrayOutputStream f = new ByteArrayOutputStream();
		
		String str = "hello world welcome";
		
		byte[] buffer = str.getBytes();
		
		f.write(buffer);
		
		byte[] result = f.toByteArray();
		
		for(int i = 0; i < result.length; i++)
		{
			System.out.println(result[i]);
			System.out.println((char)result[i]);
		}
		
		OutputStream os = new FileOutputStream("gen/test.txt");
		
		f.writeTo(os);
		
		f.close();
		os.close();
	}
}
