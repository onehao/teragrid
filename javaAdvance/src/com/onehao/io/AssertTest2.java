package com.onehao.io;

/**
 * eclipse 中怎样设置 参数来 使用 Asset 依次进入eclipse的菜单项Window -> Preferences -> Java ->
 * Compiler -> Compliance and Classfiles 将Compiler Compliance Level to 5.0.
 * 断言在java的JDK1.4版本中添加进来，这个设置告诉编译器识别和允许断言语句，但是还没有开启断言。 
 * 接下来，进入菜单项Window ->
 * Preferences -> Java -> Compiler -> Compliance and Classfiles，并且设置： 
 * Compiler Compliance Level: 5.0 
 * Use default compliance settings unchecked 
 * Generated .class files compatibility: 5.0 
 * Source compatibility: 5.0 Disallow
 * identifiers called 'assert': Error Compiler Compliance Level to 5.0
 * 选择开启或关闭Assert功能
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