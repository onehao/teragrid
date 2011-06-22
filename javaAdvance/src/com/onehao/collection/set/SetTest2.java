package com.onehao.collection.set;

import java.util.HashSet;

/**
 * 当使用HashSet时，hashCode()方法就会得到调用，
 * 判断已经存储在集合中的对象的hash code值是否与增加的对象的hash code值一致；
 * 如果不一致，直接加进去；如果一致，再进行equals方法的比较，equals方法如果返回true，
 * 表示对象已经加进去了，就不会再增加新的对象，否则加进去。
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