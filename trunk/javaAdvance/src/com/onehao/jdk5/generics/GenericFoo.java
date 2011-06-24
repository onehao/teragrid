package com.onehao.jdk5.generics;

public class GenericFoo<T>
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
		GenericFoo<Boolean> foo1 = new GenericFoo<Boolean>();
		GenericFoo<Integer> foo2 = new GenericFoo<Integer>();
		
		foo1.setFoo(new Boolean(false));
		foo2.setFoo(new Integer(3));
		
		Boolean b = foo1.getFoo();
		Integer in = foo2.getFoo();
		
		System.out.println(b);
		System.out.println(in);
		
		GenericFoo a = new GenericFoo();
		
		a.setFoo("hello");
		
		String str = (String)a.getFoo();
		
		System.out.println(str);
	}
}
