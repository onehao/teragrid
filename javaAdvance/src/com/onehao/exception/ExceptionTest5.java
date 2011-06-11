package com.onehao.exception;

public class ExceptionTest5 {

	public void method() throws Exception
	{
		try
		{
			System.out.println("进入到try块");
			//return;
			System.exit(0);
		}
		catch(Exception e)
		{
			System.out.println("异常发生");
			
			throw new Exception();
		}
		finally
		{
			System.out.println("进入到finally块");
		}
		
		System.out.println("异常处理后续代码");
	}
	
	public static void main(String[] args) throws Exception {
		ExceptionTest5 test = new ExceptionTest5();
		test.method();
	}
}
