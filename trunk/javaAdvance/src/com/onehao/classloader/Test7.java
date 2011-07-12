package com.onehao.classloader;

/**
 * 
 * ����ClassLoader���loadClass��������һ���࣬�����Ƕ��������ʹ�ã����ᵼ����ĳ�ʼ����
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
		//���ϵͳ�������
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		
		Class<?> clazz = loader.loadClass("com.onehao.classloader.D");//���Ƕ��������ʹ�ã����ᵼ����ĳ�ʼ��
		
		System.out.println("------------------------------");
		
		clazz = Class.forName("com.onehao.classloader.D");
	}
}
