package com.onehao.network.mychatroom;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client
{

	private Socket socket;

	private String name;

	InputStream is;

	OutputStream os;

	public static void main(String[] args) throws Exception
	{
		Socket socket = new Socket("localhost", 1111);
		
		Client client = new Client(socket, "onehao2");

		new ClientInputThread(socket).start();
		new ClientOutputThread(socket).start();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof Client))
		{
			return false;
		}
		Client other = (Client) obj;
		if (name == null)
		{
			if (other.name != null)
			{
				return false;
			}
		} else if (!name.equals(other.name))
		{
			return false;
		}
		return true;
	}

	public Socket getSocket()
	{
		return socket;
	}

	public void setSocket(Socket socket)
	{
		this.socket = socket;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Client(Socket socket, String name) throws Exception
	{
		this.socket = socket;
		
		this.name = name;

		os = socket.getOutputStream();

		os.write((this.name).getBytes());

	}
}
