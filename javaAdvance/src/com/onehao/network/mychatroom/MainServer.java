package com.onehao.network.mychatroom;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;



public class MainServer 
{
	static Vector<Socket> sockets;
	static Vector<Client> clients;
	
	
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(1111);
		
		while(true)
		{
			Socket socket = ss.accept();
			if(null == sockets)
			{
				sockets = new Vector<Socket>();
			}
			sockets.addElement(socket);
			
			InputStream is = socket.getInputStream();
			
			byte[] buffer = new byte[1024];
			
			System.out.println(new String(buffer));
			
			int length = is.read(buffer);
			
			//get the name of the client
			String str = new String(buffer, 0, length);
			
			
				Client client = new Client(socket, str);
				client.setName(str);
				if(null == clients)
				{
					clients = new Vector<Client>();
				}
				clients.addElement(client);
			
			
			//Æô¶¯¶ÁÐ´Ïß³Ì
			new ServerInputThread(client).start();
//			new ServerOutputThread(socket).start();
			
		}
	}
	
	
}
