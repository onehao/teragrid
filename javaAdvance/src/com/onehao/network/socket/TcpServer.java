package com.onehao.network.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpServer
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(5000);
		
		Socket socket = ss.accept();
		
		InputStream is = socket.getInputStream();
		
		byte[] buffer = new byte[200];
		
		int length = 0;
		
		while(-1 != (length = is.read(buffer, 0, buffer.length)))
		{
			String str = new String(buffer, 0 , length);
			
			System.out.println(str);
		}
		
		OutputStream os = socket.getOutputStream();
		
		os.write("welcome".getBytes());
		
		System.out.println("after os write");
		
		is.close();
		os.close();
		socket.close();
	}
}
