package com.onehao.exception;

public class ExceptionTest5 {

	public void method() throws Exception
	{
		try
		{
			System.out.println("���뵽try��");
			//return;
			System.exit(0);
		}
		catch(Exception e)
		{
			System.out.println("�쳣����");
			
			throw new Exception();
		}
		finally
		{
			System.out.println("���뵽finally��");
		}
		
		System.out.println("�쳣�����������");
	}
	
	public static void main(String[] args) throws Exception {
		ExceptionTest5 test = new ExceptionTest5();
		test.method();
	}
}
