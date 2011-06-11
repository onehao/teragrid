package com.onehao.exception;

public class ExceptionTest4 {

	public void method(String str) throws Exception
	{
		if(null == str)
		{
			throw new MyException("the string cann't be null");
		}
		else if("hello".equals(str))
		{
			throw new MyException2("�����ַ�������Ϊhello");
		}
		else
		{
			System.out.println(str);
		}
	}
	
	public static void main(String[] args){
		
		ExceptionTest4 test = new ExceptionTest4();
		
		try {
			test.method("hello");
		} catch (MyException e) {
			System.out.println("���뵽MyException catch��");
			e.printStackTrace();
		} catch (MyException2 e){
			System.out.println("���뵽MyException2 catch��");
			e.printStackTrace();
		} catch (Exception e){
			System.out.println("���뵽Exception catch��");
			e.printStackTrace();
		} finally{
		
			System.out.println("�쳣�������");
		}
		
		System.out.println("����ִ�����");
	}
}
