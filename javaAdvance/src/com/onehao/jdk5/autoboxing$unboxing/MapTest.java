package com.onehao.jdk5.autoboxing$unboxing;

import java.util.HashMap;
import java.util.Set;

public class MapTest
{
	public static void main(String[] args)
	{
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		
		for(String word : args)
		{
			Integer freq = map.get(word);
			map.put(word, (null == freq)? 1 : freq + 1);
		}
		
		System.out.println(map);
	}
}
