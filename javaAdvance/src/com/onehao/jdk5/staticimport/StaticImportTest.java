package com.onehao.jdk5.staticimport;

import static com.onehao.jdk5.staticimport.common.Common.AGE;
import static com.onehao.jdk5.staticimport.common.Common.output;

/**
 * 静态导入：
 *	a) import static com.shengsiyuan.common.Common.Age;
 *	b) import static com.shengsiyuan.common.Common.output;
 *	
 *	表示导入Common类中的静态成员变量AGE以及静态方法output。
 *  注意：使用import static时，要一直导入到类中的静态成员变量或静态方法。
 *  
 *  过度的使用这个特性会降低代码的可读性
 * @author onehao
 *
 */
public class StaticImportTest
{
	public static void main(String[] args)
	{
		int a = AGE;
	
		System.out.println(a);
	
		output();
	}
	
}
