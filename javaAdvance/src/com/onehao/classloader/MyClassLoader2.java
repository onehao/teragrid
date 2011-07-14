package com.onehao.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;

/**
 * 定义类加载器：如果某个类加载器能够加载一个类，那 么该类加载器就称作：
 * 定义类加载器；定义类加载器及其 所有子加载器都称作：初始类加载器。
 * 
 * @author onehao
 * 
 */
public class MyClassLoader2 extends ClassLoader
{
	private String name; // 类加载器名字

	private String path = "bin\\"; // 加载器路径

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	private static String fileType = ".class"; // class文件扩展名

	public MyClassLoader2(String name)
	{
		super(); // 让系统类加载器成为该类加载器的父类加载器

		this.name = name;
	}

	public MyClassLoader2(ClassLoader parent, String name)
	{
		super(parent); // 显式指定类加载器的父类加载器

		this.name = name;
	}

	@Override
	public String toString()
	{
		return this.name;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException
	{
		byte[] data = this.loadClassData(name);

		return this.defineClass(name, data, 0, data.length);
	}

	private byte[] loadClassData(String name)
	{
		InputStream is = null;
		byte[] data = null;
		ByteArrayOutputStream baos = null;

		try
		{
			name = name.replace(".", "\\");

			is = new FileInputStream(new File(path + name + fileType));

			baos = new ByteArrayOutputStream();

			int ch = 0;

			while (-1 != (ch = is.read()))
			{
				baos.write(ch);
			}

			data = baos.toByteArray();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				is.close();
				baos.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		return data;
	}

	public static void main(String[] args) throws Exception
	{
		MyClassLoader2 loader1 = new MyClassLoader2("loader1");

		loader1.setPath("gen/serverlib/");

		MyClassLoader2 loader2 = new MyClassLoader2(loader1, "loader2");

		loader2.setPath("gen/clientlib/");

		MyClassLoader2 loader3 = new MyClassLoader2(null, "loader3");

		loader3.setPath("gen/otherlib/");

//		test(loader2);// 取消auto build 删去bin/com/onehao/classloader/
//						// 下的Sample.class 和 Dog.class
//						// 输出 Sample is loaded by: loader1
//						// Dog is loaded by: loader1
//
//		// 否折输出：Sample is loaded by: sun.misc.Launcher$AppClassLoader@19821f
//		// Dog is loaded by: sun.misc.Launcher$AppClassLoader@19821f
//
//		// export Dog.class Sample.class 到D:\program
//		// files\Java\jdk1.6.0_25\jre\lib\ext
//		// 输出 ： Sample is loaded by: sun.misc.Launcher$ExtClassLoader@addbf1
//		// Dog is loaded by: sun.misc.Launcher$ExtClassLoader@addbf1
//		test(loader3);
		
//		Class clazz = loader1.loadClass("com.onehao.classloader.Sample");
//		Object object = clazz.newInstance();
//		Sample sample = (Sample)object;
//		
//		System.out.println(sample.v1);
		
//		Class clazz = loader1.loadClass("com.onehao.classloader.Sample");
//		
//		Object object = clazz.newInstance();
//		
//		Field field = clazz.getField("v1");
//		
//		int v1 = field.getInt(object);
//		
//		System.out.println(v1);
		
		//卸载
		Class clazz2 = loader1.loadClass("com.onehao.classloader.Sample");// 取消auto build 删去bin/com/onehao/classloader/
//		// 下的Sample.class 和 Dog.class
		
		System.out.println(clazz2.hashCode());
		
		Object object2 = clazz2.newInstance();
		
		loader1 = null;
		clazz2 = null;
		object2 = null;
		
		loader1 = new MyClassLoader2("loader1");
		
		loader1.setPath("gen/serverlib/");
		
		clazz2 = loader1.loadClass("com.onehao.classloader.Sample");
		
		Class clazz3 = loader1.loadClass("com.onehao.classloader.Sample");
		
		System.out.println(clazz2 == clazz3);
		
		System.out.println(clazz2.hashCode());
	}

	public static void test(ClassLoader loader) throws Exception
	{
		Class clazz = loader.loadClass("com.onehao.classloader.Sample");

		Object object = clazz.newInstance();
	}
}
