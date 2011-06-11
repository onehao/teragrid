package com.onehao.exception;

public class ExceptionTest4 {

	public void method(String str) throws MyException
	{
		if(null == str)
		{
			throw new MyException("the string cann't be null");
		}
		else
		{
			System.out.println(str);
		}
	}
	
	public static void main(String[] args){
		
		ExceptionTest4 test = new ExceptionTest4();
		
		try {
			test.method(null);
		} catch (MyException e) {
			e.printStackTrace();
		}finally{
			System.out.println("异常处理完毕");
		}
		
		System.out.println("程序执行完毕");
	}
}
