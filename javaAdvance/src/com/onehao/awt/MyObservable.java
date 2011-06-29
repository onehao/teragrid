package com.onehao.awt;

import java.util.Observable;
import java.util.Observer;

public class MyObservable extends Observable
{
	int a = 10;
	
	public int getA()
	{
		return a;
	}

	public void setA(int a)
	{
		this.a = a;
	}

	public static void main(String[] args)
	{
		MyObservable mo = new MyObservable();
		mo.addObserver(new MyObserver());
		mo.addObserver(new MyObserver2());
		
		for(int i = mo.getA(); i > 0; )
		{
			i--;
			if(mo.ischanged(i))
				mo.notifyObservers(mo.getA());
			mo.setA(i);
		}
		
//		System.out.println(mo.a);
	}
	
	@Override
	public String toString()
	{
		return "MyObservable [a=" + a + "]";
	}
	
	boolean ischanged(int a)
	{
		if(a != getA())
		{
			setChanged();
			return true;
		}
		
		return false;
	}
	
//	public synchronized boolean hasChanged() {
//		return changed;
//	    }
	
	
}

class MyObserver implements Observer
{

	@Override
	public void update(Observable o, Object arg)
	{
		System.out.println(" this is from ob1  --------" + o);
	}
	
}

class MyObserver2 implements Observer
{

	@Override
	public void update(Observable o, Object arg)
	{
		Integer in = (Integer)arg;
		if(in <= 5)
		{
			System.out.println(" this is from ob2  --------" + o);
		}
	}
	
}
