package com.onehao.jdk5.enumset$enummap;

import java.util.EnumSet;
import java.util.Iterator;

public class EnumSetDemo2
{
	public static void showEnumSet(EnumSet<FontConstant> enumSet)
	{
		for(Iterator<FontConstant> iter = enumSet.iterator(); iter.hasNext();)
		{
			System.out.println(iter.next());
		}
	}
	
	public static void main(String[] args)
	{
		EnumSet<FontConstant> enumSet = EnumSet.noneOf(FontConstant.class);
		
		enumSet.add(FontConstant.Bold);
		enumSet.add(FontConstant.Italilc);
		
		showEnumSet(enumSet);
	}
}
