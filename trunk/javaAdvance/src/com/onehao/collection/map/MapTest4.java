package com.onehao.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest4
{
	public static void main(String[] args)
	{
		System.out.println(args.length);
		
		for(int i = 0; i < args.length; i++)
		{
			System.out.println(args[i]);
		}
		
		
		HashMap map = new HashMap();
		
		for(int i = 0; i < args.length; i++)
		{
			String key = args[i];
			if(map.containsKey(key))
				map.put(key,((Integer)map.get(key)).intValue() + 1);
			else
				map.put(key, 1);
		}
		
		Set set = map.keySet();
		
		for(Iterator iter = set.iterator(); iter.hasNext();)
		{
			String key = (String)iter.next();
			int value = ((Integer)map.get(key)).intValue();
			System.out.println(key + " - " + value);
		}
	}
}
