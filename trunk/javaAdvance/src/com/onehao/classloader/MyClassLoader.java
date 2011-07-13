package com.onehao.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader
{
	private String name; //�����������
	
	private String path = "bin\\"; //������·��
	
	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	private static String fileType = ".class"; //class�ļ���չ��
	
	public MyClassLoader(String name)
	{
		super(); //��ϵͳ���������Ϊ����������ĸ��������
		
		this.name = name;
	}

	public MyClassLoader(ClassLoader parent, String name)
	{
		super(parent); //��ʽָ����������ĸ��������
		
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
			
			while(-1 != (ch = is.read()))
			{
				baos.write(ch);
			}
			
			data = baos.toByteArray();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				is.close();
				baos.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return data;
	}
	
	public static void main(String[] args) throws Exception
	{
		MyClassLoader loader1 = new MyClassLoader("loader1");
		
		loader1.setPath("gen/serverlib/");
		
		MyClassLoader loader2 = new MyClassLoader(loader1, "loader2");
		
		loader2.setPath("gen/clientlib/");
		
		MyClassLoader loader3 = new MyClassLoader(null, "loader3");
		
		loader3.setPath("gen/otherlib/");
		
		test(loader2);//ȡ��auto build ɾȥbin/com/onehao/classloader/ �µ�Sample.class �� Dog.class
					  //��� Sample is loaded by: loader1
					  //     Dog is loaded by: loader1
		
					  //���������Sample is loaded by: sun.misc.Launcher$AppClassLoader@19821f
		              //         Dog is loaded by: sun.misc.Launcher$AppClassLoader@19821f
		test(loader3);
	}
	
	public static void test(ClassLoader loader) throws Exception
	{
		Class clazz = loader.loadClass("com.onehao.classloader.Sample");
		
		Object object = clazz.newInstance();
	}
}
