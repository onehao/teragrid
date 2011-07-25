package com.onehao.network.mychatroom;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class ServerInputThread extends Thread
{
	private Socket socket;
	
	private Client client;
	
	public ServerInputThread(Socket socket)
	{
		this.socket = socket;
	}
	
	public ServerInputThread(Client client)
	{
		this.client = client;
	}
	
	@Override
	public void run()
	{
		InputStream is = null;
		try
		{
			//用ServerInputThread(Client client)构造， 则通过client.getSocket()来得到socket；
			if(null == socket)
			{
				socket = client.getSocket();
			}
			 is = socket.getInputStream();
			
//			socket.getInetAddress();
//			
//			
//			byte[] buffer1 = new byte[1024];
//			
////			System.out.println(new String(buffer1));
//			
//			int length1 = is.read(buffer1);
//			
//			//get the name of the client
//			String str1 = new String(buffer1, 0, length1);
//			
//			if(null != str1)
//			{
//				Client client = new Client(socket,str1);
////				client.setName(str1);
//				if(null == MainServer.clients)
//				{
//					MainServer.clients = new Vector<Client>();
//				}
//				MainServer.clients.addElement(client);
//			}
			
			while(true)
			{
				
				byte[] buffer = new byte[1024];
			
				int length = is.read(buffer);
				
				String str = new String(buffer, 0, length);
				
				int index ;// = str.indexOf(':', 0);
				//得到发送对象client的名字
				String name = null; // = str.substring(0, index);
				//要发送的message
				String msg = str;
				
				
				if(str.contains(":")){
					index = str.indexOf(":", 0);
					name = str.substring(0, index);
					msg = str.substring(index+1);
				}
				
				if(str.equals("list"))
				{
					for(Client c : MainServer.clients)
					{
						sendToClient(client, c.getName());
					}
				}
				else if(null == name || "".equals(name)|| "all".equals(name))
				{
//					System.out.println("sendToAll------------");
					//send to all
					sendToAll(msg);
				}
				else if(name.equals("list"))
				{
					
					for(Client c : MainServer.clients)
					{
						sendToClient(client, c.getName());
					}
					
				}
				else
				{
					for(Client c : MainServer.clients)
					{
						if(name.equals(c.getName()))
						{
							//send to client with named name;
							
							sendToClient(c,  msg);
						}
					}
				}
				
//				System.out.println(str);
			}
			
		} catch (IOException e)
		{
			
			try
			{
				is.close();
				client.getSocket().close();
				MainServer.sockets.removeElement(client.getSocket());
				MainServer.clients.removeElement(client);
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void sendToAll(String msg) throws Exception
	{
		for(Socket s : MainServer.sockets)
		{
			OutputStream os = s.getOutputStream();
			
			os.write((this.client.getName() + ">>" + msg).getBytes());
		}
	}
		
	
	
	private void sendToClient(Client client, String msg) throws Exception
	{
		Socket socket = client.getSocket();
		OutputStream os = socket.getOutputStream();
		
		os.write((this.client.getName() + ">>" + msg).getBytes());
	}
}
