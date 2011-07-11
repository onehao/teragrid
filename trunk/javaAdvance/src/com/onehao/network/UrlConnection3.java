package com.onehao.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlConnection3
{
	public static void main(String[] args) throws Exception
	{
		URL url = new URL("http://www.sohu.com");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"GBK"));
		
		String line = null;
		
		while(null != (line = br.readLine()))
		{
			System.out.println(line);
		}
		
		br.close();
	}
}
