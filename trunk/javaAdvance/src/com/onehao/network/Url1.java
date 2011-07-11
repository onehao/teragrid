package com.onehao.network;

import java.net.MalformedURLException;
import java.net.URL;

public class Url1
{
	public static void main(String[] args) throws MalformedURLException
	{
		URL url = new URL("http://java.sun.com:80/docs/books/tutorial/index.html#DOWN");
		
		String protocal = url.getProtocol();
		String host = url.getHost();
		String file = url.getFile();
		int port = url.getPort();
		String ref = url.getRef();
		
		System.out.println(protocal + ", " + host + ", " + file + ", " + port + ", " + ref);
	}
}
