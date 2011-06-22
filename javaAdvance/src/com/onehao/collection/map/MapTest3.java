package com.onehao.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest3
{
	public static void main(String[] args)
	{
		HashMap map = new HashMap();
		
		map.put("a", "AA");
		map.put("b", "BB");
		map.put("c", "CC");
		map.put("d", "DD");
		map.put("e", "EE");
		
		Set set = map.keySet();
		
		for(Iterator iter = set.iterator();iter.hasNext();)
		{
			String key = (String)iter.next();
			String value = (String)map.get(key);
			System.out.println(key + " - " + value);
		}
	}
}
