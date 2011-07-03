package com.onehao.io4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest1
{
	
	public static void main(String[] args) throws Exception
	{
		Person p1 = new Person(20, "zhangsan", 4.55);
		Person p2 = new Person(50, "lisi", 4.67);
		Person p3 = new Person(10, "wangwu", 17.78);
	
	
		FileOutputStream fos = new FileOutputStream("gen/person.serial");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(p1);
		oos.writeObject(p2);
		oos.writeObject(p3);
		
		oos.close();
		
		FileInputStream fis = new FileInputStream("gen/person.serial");
		
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//按写入顺序讲对象读出
		System.out.println((Person)ois.readObject());
		System.out.println((Person)ois.readObject());
		System.out.println((Person)ois.readObject());
//		System.out.println((Person)ois.readObject()); // java.io.EOFException
		
		ois.close();
		
		
	}
	
}

@SuppressWarnings("serial")
class Person implements Serializable
{
	int age;
	
	transient String name;
	
	double height;
	
	public Person(int age, String name, double height)
	{
		this.age = age;
		this.name = name;
		this.height = height;
	}

	@Override
	public String toString()
	{
		return "Person [age=" + age + ", height=" + height + "]";
	}
}