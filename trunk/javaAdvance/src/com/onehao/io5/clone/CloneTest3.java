package com.onehao.io5.clone;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * �Ѷ���д������Ĺ��������л���Serilization�����̣����Ѷ�������ж������Ĺ�������������л���Deserialization�����̡�
 * Ӧ��ָ�����ǣ�д��������Ƕ����һ����������ԭ������Ȼ������JVM���档
 * 
 * 
 * ��Java���������һ�����󣬳���������ʹ����ʵ��Serializable�ӿڣ�
 * Ȼ��Ѷ���ʵ����ֻ�Ƕ����һ��������д��һ������ٴ������������������ؽ�����
 * 
 * 
 * ��������ǰ���Ƕ����Լ������ڲ��������õ��Ķ����ǿɴ��л��ģ�
 * ���򣬾���Ҫ��ϸ������Щ���ɴ��л��Ķ���ɷ����transient���Ӷ���֮�ų��ڸ��ƹ���֮�⡣
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
	 * �����Ķ������л���浽Ӳ������󣬿��Ǻ�����ȴ���������field(���ӻ���ٻ����)��
	 * ���㷴���л�ʱ���ͻ����Exception�ģ������ͻ���ɲ������Ե����⡣
	 * 
	 * ����serialVersionUID��ͬʱ�����ͻὫ��һ����field��type��ȱʡֵDeserialize��
	 * ������Աܿ��������Ե����⡣
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
