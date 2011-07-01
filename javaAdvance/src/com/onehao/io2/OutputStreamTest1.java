package com.onehao.io2;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutputStreamTest1
{
	public static void main(String[] args) throws Exception
	{
		OutputStream os = new FileOutputStream("gen/OutputStream.java.bak", true);
		
		String str = "welcome";
		
		byte[] buffer = str.getBytes();
		
		os.write(buffer);
		
		os.close();
	}
}
