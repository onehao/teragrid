package com.onehao.io;

/**
 * eclipse ���������� ������ ʹ�� Asset ���ν���eclipse�Ĳ˵���Window -> Preferences -> Java ->
 * Compiler -> Compliance and Classfiles ��Compiler Compliance Level to 5.0.
 * ������java��JDK1.4�汾����ӽ�����������ø��߱�����ʶ������������䣬���ǻ�û�п������ԡ� 
 * ������������˵���Window ->
 * Preferences -> Java -> Compiler -> Compliance and Classfiles���������ã� 
 * Compiler Compliance Level: 5.0 
 * Use default compliance settings unchecked 
 * Generated .class files compatibility: 5.0 
 * Source compatibility: 5.0 Disallow
 * identifiers called 'assert': Error Compiler Compliance Level to 5.0
 * ѡ������ر�Assert����
 * 
 * @author onehao
 * 
 */
public class AssertTest2
{
	public static void main(String[] args)
	{
		AssertTest2 at = new AssertTest2();
		at.assertMe(true);
		at.assertMe(false);
	}

	private void assertMe(boolean boo)
	{
		String s = null;
		assert boo ? true : false : s = "hello world";
		System.out.println("true condition");
	}
}