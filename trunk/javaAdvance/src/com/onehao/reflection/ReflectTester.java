package com.onehao.reflection;

import java.lang.reflect.Constructor;

public class ReflectTester {
	
	//该方法实现对Customer对象的拷贝操作
	public Object copy(Object object) throws Exception{
		Class<?> classType = object.getClass();
		
		Constructor cons = classType.getConstructor(new Class[]{String.class, int.class});
		
		Object obj = cons.newInstance(new Object[]{"hello", 3});
		
		//以上两行代码等价于下面一行
//		Object obj2 = classType.newInstance();
		
		System.out.println(obj);
		
		return obj;
	}
	
	public static void main(String[] args) throws Exception {
		ReflectTester test = new ReflectTester();
		test.copy(new Customer());
	}
}
class Customer
{
	private Long id;
	
	private String name;
	
	private int age;
	
	public Customer()
	{
	}
	
	public Customer(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
