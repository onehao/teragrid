package com.onehao.innerclass;

/**
 * static inner classes (also called nested classes)
 * 
 * ��̬�ڲ��ࣨstatic inner class����ֻ�ܷ����ⲿ��ľ�̬��Ա�����뾲̬������
 * ���ɾ�̬�ڲ������ķ�ʽΪ��
 * OuterClass.InnerClass inner = new OuterClass.InnerClass();
 * 
 * @author onehao
 *
 */
class StaticInner
{
	private static int a = 4;
	
	public static class Inner
	{
		public void test()
		{
			System.out.println(a);
		}
	}
	
}
public class StaticInnerClassTest
{
	public static void main(String[] args)
	{
		StaticInner.Inner inner = new StaticInner.Inner();
	
		inner.test();
	}
}
