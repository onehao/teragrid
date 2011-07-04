package com.onehao.io;

/**
 * 
 * run 的时候需要在vm vaiable中加入-ea
 * @author onehao
 *
 */
public class AssertTest1
{
	public static void main(String[] args)
	{
		AssertTest1 at = new AssertTest1();
		at.assertMe(true);
		at.assertMe(false);
	}

	private void assertMe(boolean boo)
	{
		assert boo ? true : false;
		System.out.println("true condition");
	}
}