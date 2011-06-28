package com.onehao.innerclass;

import java.util.Date;


/**
 * �����ڲ��ࣨAnonymous Inner Class����
 * �����ڲ������ʽ�ؼ̳�һ�������ʵ��һ���ӿڡ�
 * 
 * 
 * Local inner classes which don��t have class names
 * No key word class
 * No key word extends and implements
 * No constructors
 * Implicitly extend a superclass or implement an interface


 * @author onehao
 *
 */


public class AnonymousInnerClassTest
{
	@SuppressWarnings("deprecation")
	public String get(Date date)
	{
		return date.toLocaleString();
	}
	
	public static void main(String[] args)
	{
		AnonymousInnerClassTest test = new AnonymousInnerClassTest();
		
		String str = test.get(new Date());
		
		System.out.println(str);
		
		String str2 = test.get(new Date(){
			
		}); //����һ������Date�����Ķ���
		
		System.out.println(str2);
		
		String str3 = test.get(new Date(){
			public String toLocaleString()
			{
				return "hello world";
			}
		});
		System.out.println(str3);
	}
}
