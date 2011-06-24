package com.onehao.collection.map;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TestHashCode
{
	public static void main(String[] args) throws Exception
	{
		System.out.println(new Integer(14576877).hashCode());
		
		System.out.println(new Object().hashCode());
		
		HashMap map = new HashMap();
		
		map.put(2, 3);
		
		map.put(2, 4);
		
		System.out.println(map.get(2));
		
		Class clazz = Class.forName("java.util.HashMap");
		Class innerClazz = Class.forName("java.util.HashMap$Entry");
		
//		Method put = clazz.getDeclaredMethod("put", new Class[]{Object.class, Object.class});
		
		Field f = innerClazz.getDeclaredField("next");
		Map.Entry entry = (Map.Entry)innerClazz.newInstance();
		entry.getValue();
		
	}
}
