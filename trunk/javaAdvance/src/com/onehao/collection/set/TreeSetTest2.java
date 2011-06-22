package com.onehao.collection.set;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest2
{
	public static void main(String[] args)
	{
		TreeSet set = new TreeSet();
		
		Examinee e1 = new Examinee(10);
		Examinee e2 = new Examinee(20);
		Examinee e3 = new Examinee(30);
		Examinee e4 = new Examinee(40);
		
		set.add(e1);
		set.add(e2);
//		set.add(e3);
//		set.add(e4);
		
		System.out.println(set);
	}
}

class Examinee implements Comparator
{
	int score;
	
	Examinee(int score)
	{
		this.score = score;
	}

	@Override
	public String toString()
	{
		return "Examinee [score=" + score + "]";
	}

	@Override
	public int compare(Object o1, Object o2)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}