package com.onehao.io;

import java.io.File;

/**
 * ��ҵ����������һ��Ŀ¼�������η�ʽչ�ֳ���Ŀ¼�е�������Ŀ¼���ļ���
 * ���⣬��չ�ֵ�ʱ��Ŀ¼�������棬�ļ��������档ÿһ��Ҫ��������
 * @author onehao
 *
 */
public class MyFileRecursion
{
	public static void fileTree(File file, String sep)
	{
		
		System.out.print(sep);
		//�����Ŀ¼
		if(file.isDirectory())
		{
			//��ӡ����Ŀ¼�� ÿ����һ�ε�ǰ�ڵ㼴��Ϊ��Ŀ¼
			System.out.println(file.getName());
			
			File[] files = file.listFiles();
			
			sep = sep + sep.substring(0, 2);
			
			//�����Ŀ¼
			for(int i = 0; i < files.length; i++)
			{
				if(files[i].isDirectory())
				fileTree(files[i],sep);
			}
			
			//������ļ�
			for(int i = 0; i < files.length; i++)
			{
				if(files[i].isFile())
				fileTree(files[i],sep);
			}
		}
		else
		{
			System.out.println(file.getName());
		}
	}
	
	public static void main(String[] args)
	{
		File file = new File("E:\\training myself\\java\\gen");
		fileTree(file, "  ");
		
	}
}
