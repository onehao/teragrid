package com.onehao.io5.clone;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * 把对象写到流里的过程是序列化（Serilization）过程，而把对象从流中读出来的过程则叫做反序列化（Deserialization）过程。
 * 应当指出的是，写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。
 * 
 * 
 * 在Java语言里深复制一个对象，常常可以先使对象实现Serializable接口，
 * 然后把对象（实际上只是对象的一个拷贝）写到一个流里，再从流里读出来，便可以重建对象。
 * 
 * 
 * 这样做的前提是对象以及对象内部所有引用到的对象都是可串行化的，
 * 否则，就需要仔细考察那些不可串行化的对象可否设成transient，从而将之排除在复制过程之外。
 * 
 * @author onehao
 */
public class CloneTest3
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		Teacher3 t = new Teacher3();
		
		t.setAge(40);
		t.setName("Teacher zhang");
		
		Student3 s1 = new Student3();
		
		s1.setAge(20);
		s1.setName("lisi");
		s1.setTeacher3(t);
		
		Student3 s2 = (Student3)s1.deepCopy();
		
		System.out.println(s2.getAge());
		System.out.println(s2.getName());
		
		
		System.out.println(" --------------------- ");
		
		System.out.println(s2.getTeacher3().getAge());
		System.out.println(s2.getTeacher3().getName());
		
//		s2.getTeacher3().setAge(50);
//		s2.getTeacher3().setName("Teacher wang");
		
		t.setAge(55);
		t.setName("one");
		
		System.out.println(s2.getTeacher3().getAge());
		System.out.println(s2.getTeacher3().getName());
	}
}

class Teacher3 implements Serializable
{

	/**
	 * 如果你的对象序列化后存到硬盘上面后，可是后来你却更改了类的field(增加或减少或改名)，
	 * 当你反序列化时，就会出现Exception的，这样就会造成不兼容性的问题。
	 * 
	 * 但当serialVersionUID相同时，它就会将不一样的field以type的缺省值Deserialize，
	 * 这个可以避开不兼容性的问题。
	 * 
	 */
	private static final long serialVersionUID = 4637657405442418863L;

	private int age;
	
	private String name;

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}


class Student3 implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8780157779147039616L;

	private int age;
	
	private String name;
	
	private Teacher3 teacher3;

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Teacher3 getTeacher3()
	{
		return teacher3;
	}

	public void setTeacher3(Teacher3 teacher3)
	{
		this.teacher3 = teacher3;
	}
	
	public Object deepCopy() throws IOException, ClassNotFoundException
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		oos.writeObject(this);
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		return ois.readObject();
	}
}
