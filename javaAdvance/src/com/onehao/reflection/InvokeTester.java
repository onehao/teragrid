package com.onehao.reflection;

import java.lang.reflect.Method;

/**
 * @author onehao
 *
 */
public class InvokeTester {
	public int add(int param1, int param2){
		return param1 + param2;
	}
	
	public String echo(String message){
		return "hello:" + message;
	}
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
//		InvokeTester test = new InvokeTester();
//		System.out.println(test.add(1, 2));
//		System.out.println(test.echo("onehao"));
		
		Class<?> classType = InvokeTester.class;//第二种方式。
		
		Object invokeTester = classType.newInstance();
		
//		System.out.println(invokeTester instanceof InvokeTester);
		
		Method addMethod = classType.getMethod("add", new Class[]{int.class,int.class});
		
		Object result = addMethod.invoke(invokeTester, new Object[]{1,2});
		
		System.out.println((Integer)result);
		
		System.out.println("-----------------");
		
		Method echoMethod = classType.getMethod("echo", String.class);
		
		Object result2 = echoMethod.invoke(invokeTester, "onehao");
		
		System.out.println(result2);
	}
}
