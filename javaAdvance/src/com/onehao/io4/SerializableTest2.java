package com.onehao.io4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest2
{
	public static void main(String[] args) throws Exception
	{
		Person3 p1 = new Person3(20, "zhangsan", 4.55);
		Person3 p2 = new Person3(50, "lisi", 4.67);
		Person3 p3 = new Person3(10, "wangwu", 17.78);

		FileOutputStream fos = new FileOutputStream("gen/Person2.txt");

		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(p1);
		oos.writeObject(p2);
		oos.writeObject(p3);

		oos.close();

		System.out.println("--------------------");

		FileInputStream fis = new FileInputStream("gen/Person2.txt");

		ObjectInputStream ois = new ObjectInputStream(fis);

		Person3 p = null;

		for (int i = 0; i < 3; i++)
		{
			p = (Person3) ois.readObject();

			System.out.println(p.age + "," + p.name + "," + p.height);
		}

		ois.close();
	}
}

class Person3 implements Serializable
{
	int age;

	String name;

	double height;

	public Person3(int age, String name, double height)
	{
		this.age = age;
		this.name = name;
		this.height = height;
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException
	{
		out.writeInt(age);
		out.writeUTF(name);
		
		System.out.println("write object");
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException,
			ClassNotFoundException
	{
		age = in.readInt();
		name = in.readUTF();
		
		System.out.println("read object");
	}

	
	
	
	
	
	
	
	
	
	
	
}
