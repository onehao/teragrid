package com.onehao.basic.lesson3;

/**
 * 
 * @author onehao
 *
 * 18. ����ԵıȽϣ�==��
 *	1�� ����ԭ������������˵���Ƚϵ����������ߵ�ֵ�Ƿ���ȡ�
 *	2�� ��������������˵���Ƚ��������ߵ������Ƿ�ָ��ͬһ�����󣬻���˵�������ߵ����õ�ַ�Ƿ���ͬ��
 *
 */

public class EqualsTest
{
	public static void main(String[] args)
	{
		Student2 s1 = new Student2("zhangsan");
		Student2 s2 = new Student2("zhangsan");

		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));		
	}
}

class Student2
{
	String name;

	public Student2(String name)
	{
		this.name = name;
	}
	
	public boolean equals(Object anObject)
	{
		if(this == anObject)
		{
			return true;
		}

		if(anObject instanceof Student2)
		{
			Student2 student = (Student2)anObject;
			
			if(student.name.equals(this.name))
			{
				return true;
			}
		}

		return false;
	}

}
