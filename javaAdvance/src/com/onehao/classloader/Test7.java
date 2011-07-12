package com.onehao.classloader;

/**
 * 
 * 调用ClassLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化。
 * 
 * @author onehao
 *
 */
class D
{
	static
	{
		System.out.println("Class D");
	}
}

public class Test7
{
	public static void main(String[] args) throws Exception
	{
		//获得系统类加载器
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		
		Class<?> clazz = loader.loadClass("com.onehao.classloader.D");//不是对类的主动使用，不会导致类的初始化
		
		System.out.println("------------------------------");
		
		clazz = Class.forName("com.onehao.classloader.D");
	}
}
