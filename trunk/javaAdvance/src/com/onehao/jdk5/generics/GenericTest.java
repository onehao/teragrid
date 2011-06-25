package com.onehao.jdk5.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 使用<?>或是<? extends SomeClass>的声明方式，意味著您只能通过该名称來取得所参考实例的信息，
 * 或者是移除某些信息，但不能增加它的信息，因为只知道当中放置的是SomeClass的子类，
 * 但不确定是什么类的实例，编译器不让您加入信息，理由是，如果可以加入信息的話，
 * 那么您就得記得取回的实例是什么类型，然后转换为原來的类型方可进行操作，这就失去了使用泛型的意义。
 * 
 * ge4.setFoo("welcome");编译错误
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
		
//		ge4.setFoo("welcome"); //编译错误
		
		
	}
}
