package com.onehao.reflection;

import java.lang.reflect.Method;

/**
 * @author onehao
 *
 */
public class DumpMethods {
	public static void main(String[] args) throws Exception{
		Class<?> classType = Class.forName(args[0]); //第一种方法。
		
		Method[] methods = classType.getDeclaredMethods();
		
		for(Method m : methods){
			System.out.println(m);
		}
		}
}
