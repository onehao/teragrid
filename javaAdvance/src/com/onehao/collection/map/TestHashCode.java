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
		
		Method put = clazz.getMethod("put", new Class[]{Object.class, Object.class});
		
		Map m = (Map)clazz.newInstance();
		put.invoke(m, new Object[]{2, 3});
		put.invoke(m, new Object[]{2, 4});
		
		Method getValue = innerClazz.getMethod("getValue", new Class[]{});
		
		getValue.invoke(m, null);
		
		Class[] innerClass = clazz.getClasses();
		
	}
}
