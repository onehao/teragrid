package com.onehao.jdk5.varargs;

/**
 * �ɱ�������ɱ���������Ͼ���һ�����飬����ĳ�������˿ɱ�����ķ�����˵��
 * ���Ǽȿ��Դ�����ɢ��ֵ��Ҳ���Դ����������
 * ������������еĲ�������Ϊ���飬��ôֻ�ܴ��������������ܴ�����ɢ��ֵ��
 * 
 * 
 * �ɱ��������Ҫ��Ϊ�������������һ����������һ�����������ܾ����������������ϵĿɱ������
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
