package com.onehao.jdk5.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * ʹ��<?>����<? extends SomeClass>��������ʽ����ζ����ֻ��ͨ�������Ɓ�ȡ�����ο�ʵ������Ϣ��
 * �������Ƴ�ĳЩ��Ϣ������������������Ϣ����Ϊֻ֪�����з��õ���SomeClass�����࣬
 * ����ȷ����ʲô���ʵ����������������������Ϣ�������ǣ�������Լ�����Ϣ��Ԓ��
 * ��ô���͵�ӛ��ȡ�ص�ʵ����ʲô���ͣ�Ȼ��ת��Ϊԭ������ͷ��ɽ��в��������ʧȥ��ʹ�÷��͵����塣
 * 
 * ge4.setFoo("welcome");�������
 * 
 * @author onehao
 *
 * @param <T>
 */
public class GenericTest<T>
{
	private T foo;
	public T getFoo()
	{
		return foo;
	}
	public void setFoo(T foo)
	{
		this.foo = foo;
	}
	public static void main(String[] args)
	{
		GenericTest<? extends List> ge = null;
		
		ge = new GenericTest<ArrayList>();
		ge = new GenericTest<LinkedList>();
		
//		ge = new GenericTest<Map>();
		
		GenericTest <? super List> ge2 = null;
		
		ge2 = new GenericTest<Object>();
		
		GenericTest<String> ge3 = new GenericTest<String>();
		ge3.setFoo("hello world");
		
		GenericTest<? extends Object> ge4 = ge3;
		
		System.out.println(ge4.getFoo());
		
		ge4.setFoo(null);
		
		System.out.println(ge4.getFoo());
		
//		ge4.setFoo("welcome"); //�������
		
		
	}
}
