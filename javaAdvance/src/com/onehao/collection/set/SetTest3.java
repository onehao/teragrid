package com.onehao.collection.set;

import java.util.HashSet;

/**
 * ���������дequals��������ôҲҪ��дhashCode��������֮��Ȼ��
 * @author onehao
 *
 *
 *2. ����Object���equals�������ص�
	a) �Է��ԣ�x.equals(x)Ӧ�÷���true
	b) �Գ��ԣ�x.equals(y)Ϊtrue����ôy.equals(x)ҲΪtrue��
	c) �����ԣ�x.equals(y)Ϊ true����y.equals(z)Ϊtrue����ôx.equals(z)ҲӦ��Ϊtrue��
	d) һ���ԣ�x.equals(y)�ĵ�һ�ε���Ϊtrue����ôx.equals(y)�ĵڶ��Ρ������Ρ���n�ε���ҲӦ��Ϊtrue��
	ǰ���������ڱȽ�֮��û���޸�xҲû���޸�y��
	e) ���ڷǿ�����x��x.equals(null)����false��
	3. ����Object���hashCode()�������ص㣺
	a) ��JavaӦ�õ�һ��ִ�й��̵��У�����ͬһ�������hashCode�����Ķ�ε��ã�����Ӧ�÷���ͬ����ֵ��ǰ���Ǹö������Ϣû�з����仯����
	b) ��������������˵�����ʹ��equals�����ȽϷ���true����ô�����������hashCodeֵһ������ͬ�ġ�
	c) ��������������˵�����ʹ��equals�����ȽϷ���false����ô�����������hashCodeֵ��Ҫ��һ����ͬ��������ͬ�����Բ�ͬ����
	���������ͬ��������Ӧ�õ����ܡ�
	d) ����Object����˵����ͬ��Object�����hashCodeֵ�ǲ�ͬ�ģ�Object���hashCodeֵ��ʾ���Ƕ���ĵ�ַ����
 */
public class SetTest3
{
	public static void main(String[] args)
	{
		HashSet set = new HashSet();
		
		Student s1 = new Student("zhangsan");
		Student s2 = new Student("zhangsan");
		
		set.add(s1);
		set.add(s2);
		
		System.out.println(set);
	}
}

class Student
{
	String name;
	public Student(String name)
	{
		this.name = name;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
//	@Override
//	public int hashCode()
//	{
//		return this.name.hashCode();
//	}
//	
//	public boolean equals(Object obj)
//	{
//		if(this == obj)
//		{
//			return true;
//		}
//		
//		if(null != obj && obj instanceof Student)
//		{
//			Student s = (Student)obj;
//			
//			if(name.equals(s.name))
//			{
//				return true;
//			}
//		}
//		
//		return false;
//	}
	
	
	
}
