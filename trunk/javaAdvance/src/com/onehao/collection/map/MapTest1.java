package com.onehao.collection.map;

import java.util.HashMap;

public class MapTest1
{
	public static void main(String[] args)
	{
		HashMap map = new HashMap();
		
		map.put("a", "zhangsan");
		map.put("b", "lisi");
		map.put("c", "wangwu");
		
		map.put("a", "zhaoliu");
		
		System.out.println(map);
		
		System.out.println(map.get("a"));
		
		System.out.println(map.containsKey("a"));
		
		System.out.println(map.containsValue("zhaoliu"));
		
		String value = (String)map.get("b");
		
		String value2 = (String)map.get("d");
		
		System.out.println(value2);
		
		System.out.println(map.size());
		
		
		
		
	}
}
