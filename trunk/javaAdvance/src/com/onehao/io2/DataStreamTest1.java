package com.onehao.io2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest1
{
	public static void main(String[] args) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream("gen/data.txt")));
		
		byte b = 3;
		int i = 12;
		char ch = 'a';
		float f = 3.3f;
		
		dos.writeByte(b);
		dos.writeInt(i);
		dos.writeChar(ch);
		dos.writeFloat(f);
		
		dos.close();
		
		DataInputStream dis = new DataInputStream(new BufferedInputStream(
				new FileInputStream("gen/data.txt")));
		
		System.out.println(dis.readByte());//读的时候要和写的顺序相同
		System.out.println(dis.readInt());
		System.out.println(dis.readChar());
		System.out.println(dis.readFloat());
	}
}
