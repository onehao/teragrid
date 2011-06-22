package com.onehao.collection.set;

import java.util.HashSet;

/**
 * ��ʹ��HashSetʱ��hashCode()�����ͻ�õ����ã�
 * �ж��Ѿ��洢�ڼ����еĶ����hash codeֵ�Ƿ������ӵĶ����hash codeֵһ�£�
 * �����һ�£�ֱ�Ӽӽ�ȥ�����һ�£��ٽ���equals�����ıȽϣ�equals�����������true��
 * ��ʾ�����Ѿ��ӽ�ȥ�ˣ��Ͳ����������µĶ��󣬷���ӽ�ȥ��
 * @author onehao
 *
 */

public class SetTest2 {

	public static void main(String[] args) {
		
		HashSet set = new HashSet();
		
//		set.add(new People("zhangsan"));
//		set.add(new People("lisi"));
//		
//		set.add(new People("zhangsan"));
		
		//---------------------------
		
//		People p1 = new People("zhangsan");
//		
//		set.add(p1);
//		set.add(p1);
		
		//----------------------------
		
		String s1 = new String("a");
		String s2 = new String("a");
		
		System.out.println("hash code: " + (s1.hashCode() == s2.hashCode()));
		
		set.add(s1);
		set.add(s2);
		
		
		System.out.println(set);
	}
}

class People
{
	String name;
	
	@Override
	public String toString() {
		return "People [name=" + name + "]";
	}

	public People(String name)
	{
		this.name = name;
	}
}