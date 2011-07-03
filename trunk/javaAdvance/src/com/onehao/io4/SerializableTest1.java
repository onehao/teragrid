package com.onehao.io4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest1
{
	
	public static void main(String[] args) throws Exception
	{
//		Person p1 = new Person(20, "zhangsan", 4.55);
//		Person p2 = new Person(50, "lisi", 4.67);
//		Person p3 = new Person(10, "wangwu", 17.78);
//	
//	
//		FileOutputStream fos = new FileOutputStream("gen/person.serial");
//		
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		
//		oos.writeObject(p1);
//		oos.writeObject(p2);
//		oos.writeObject(p3);
//		
//		oos.close();
//		
//		FileInputStream fis = new FileInputStream("gen/person.serial");
//		
//		ObjectInputStream ois = new ObjectInputStream(fis);
//		
//		//按写入顺序讲对象读出
//		System.out.println((Person)ois.readObject());
//		System.out.println((Person)ois.readObject());
//		System.out.println((Person)ois.readObject());
////		System.out.println((Person)ois.readObject()); // java.io.EOFException
//		
//		ois.close();
		
		
		Person2 p1 = new Person2(20, "zhangsan", 4.55);
		Person2 p2 = new Person2(50, "lisi", 4.67);
		Person2 p3 = new Person2(10, "wangwu", 17.78);
	
	
		FileOutputStream fos = new FileOutputStream("gen/person2.serial");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(p1);
		oos.writeObject(p2);
		oos.writeObject(p3);
		
		oos.close();
		
		FileInputStream fis = new FileInputStream("gen/person2.serial"); //二进制文件中没有属性值信息 如果不在writeobject里添加的话
		
		ObjectInputStream ois = new ObjectInputStream(fis);
		Person2 p = null;
		//按写入顺序讲对象读出
		for(int i = 0; i < 3; i++)
		{
			p = (Person2)ois.readObject();
			
			System.out.println("age:" + p.age + ", name:" + p.name + ", height:" + p.height);
		}
		
		ois.close();
		
		
	}
	
}

class Person2 implements Serializable
{
	int age;
	
	String name;
	
	double height;
	
	public Person2(int age, String name, double height)
	{
		this.age = age;
		this.name = name;
		this.height = height;
	}

	@Override
	public String toString()
	{
		return "Person2 [age=" + age + ", height=" + height + "]";
	}
	
	private void writeObject(java.io.ObjectOutputStream out)throws IOException
	{
		out.writeInt(age);
		out.writeUTF(name);
		System.out.println("write object");
	}
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException
    {
    	age = in.readInt();
    	name = in.readUTF();
    	System.out.println("read object");
    }

}

//@SuppressWarnings("serial")
//class Person implements Serializable
//{
//	int age;
//	
//	transient String name;
//	
//	double height;
//	
//	public Person(int age, String name, double height)
//	{
//		this.age = age;
//		this.name = name;
//		this.height = height;
//	}
//
//	@Override
//	public String toString()
//	{
//		return "Person [age=" + age + ", height=" + height + "]";
//	}
//}