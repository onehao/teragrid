package com.onehao.middle.l4;

public class MyReview {

	public static void main(String[] args) {
		
		Student s1 = new Student("haha");
		
		Student s2 = new Student("haha");
		
		System.out.println(s1.equals(s2));
		
		System.out.println(s1 == s2);
	}
}

class Student
{
	String name;
	Student(String name)
	{
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
		{
			return true;
		}
		
		if(obj instanceof Student)
		{
			Student student = (Student)obj;
			if(this.name.equals(student.name))
			{
				return true;
			}
		}
		return false;
	}
}