package com.onehao.innerclass;

import java.util.Date;


/**
 * 匿名内部类（Anonymous Inner Class）：
 * 匿名内部类会隐式地继承一个父类或实现一个接口。
 * 
 * 
 * Local inner classes which don’t have class names
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
			
		}); //创建一个集成Date类的类的对象
		
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
