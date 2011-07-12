package com.onehao.classloader;

public class Test1
{
	public static void main(String[] args) throws Exception
	{
		Class clazz = Class.forName("java.lang.String");
		
		System.out.println(clazz.getClassLoader());//String是由根类加载器加载
												   //This method will return null in such implementations if this class was loaded by the bootstrap class loader. 		
	
		Class clazz2 = Class.forName("com.onehao.classloader.C");
		
		System.out.println(clazz2.getClassLoader());
	}
}

class C
{
	
}
