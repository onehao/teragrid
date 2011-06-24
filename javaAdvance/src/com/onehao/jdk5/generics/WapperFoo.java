package com.onehao.jdk5.generics;
public class WapperFoo<T>
{
	private GenericFoo3<T> foo;

	public GenericFoo3<T> getFoo()
	{
		return foo;
	}

	public void setFoo(GenericFoo3<T> foo)
	{
		this.foo = foo;
	}
	
	public static void main(String[] args)
	{
		GenericFoo3<Integer> foo = new GenericFoo3<Integer>();
		foo.setFoo(new Integer(-10));
		
		WapperFoo<Integer> wapper = new WapperFoo<Integer>();
		wapper.setFoo(foo);
		
		GenericFoo3<Integer> g = wapper.getFoo();
		
		System.out.println(g.getFoo());
	}
}

class GenericFoo3<T>
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
}