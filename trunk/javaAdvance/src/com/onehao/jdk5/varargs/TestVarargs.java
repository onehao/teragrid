package com.onehao.jdk5.varargs;

/**
 * 可变参数：可变参数本质上就是一个数组，对于某个声明了可变参数的方法来说，
 * 我们既可以传递离散的值，也可以传递数组对象。
 * 但如果将方法中的参数定义为数组，那么只能传递数组对象而不能传递离散的值。
 * 
 * 
 * 可变参数必须要作为方法参数的最后一个参数，即一个方法不可能具有两个或两个以上的可变参数。
 * @author onehao
 *
 */
public class TestVarargs
{

	private static int sum(String s, int... nums)
	{
		System.out.println(s);
		int sum = 0;
		for(int num : nums)
		{
			sum += num;
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		int result = sum("hello",1, 2);
		
		System.out.println(result);
		
		result = sum("world",1, 2, 3, 4);
		
		System.out.println(result);
	}
}
