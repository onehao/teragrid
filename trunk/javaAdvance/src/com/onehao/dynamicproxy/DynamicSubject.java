package com.onehao.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * �Ǵ�������ڲ�������Object���ͣ�ʵ��ʹ�õ�ʱ��ͨ������Ĺ��췽�����ݽ���һ������
 * ���⣬���໹ʵ����invoke�������Ƿ����е�method.invoke��ʵ���ǵ��ñ��������Ľ�Ҫ
 * ִ�еķ���������������sub�� ��ʾ�÷���������sub��ͨ����̬�����������ǿ�����ִ����ʵ
 * ����ķ���ǰ������Լ���һЩ���ⷽ����
 * @author onehao
 *
 */
public class DynamicSubject implements InvocationHandler {

	private Object sub;
	
	public DynamicSubject(Object obj)
	{
		this.sub = obj;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		System.out.println("before calling: " + method);
	
		method.invoke(sub, args);
		
		System.out.println(args == null);
		
		System.out.println("after calling: " + method);
	
		return null;
	}

}
