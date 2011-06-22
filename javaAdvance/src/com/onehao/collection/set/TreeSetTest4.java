package com.onehao.collection.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 
 * @author onehao
 *
 */
public class TreeSetTest4
{
	public static void main(String[] args)
	{
		TreeSet set = new TreeSet(new Examinee());
		
		Examinee e1 = new Examinee(50);
		Examinee e2 = new Examinee(20);
		Examinee e3 = new Examinee(30);
		Examinee e4 = new Examinee(40);
		
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		
		System.out.println(set);
	}
}

class Examinee2 
{
	int score;
	
	Examinee2(int score)
	{
		this.score = score;
	}

	@Override
	public String toString()
	{
		return "Examinee [score=" + score + "]";
	}
}

class ExamineeComparator implements Comparator
{

	@Override
	public int compare(Object o1, Object o2)
	{
		Examinee2 e1 = (Examinee2)o1;
		Examinee2 e2 = (Examinee2)o2;
		
		return e1.score - e2.score;
	}
	
}