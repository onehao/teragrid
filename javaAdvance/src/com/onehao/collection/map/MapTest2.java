package com.onehao.collection.map;

import java.util.HashMap;

/**
 * Map（映射）：Map的keySet()方法会返回key的集合，
 * 因为Map的键是不能重复的，因此keySet()方法的返回类型是Set；而Map的值是可以重复的，
 * 因此values()方法的返回类型是Collection，可以容纳重复的元素。
 * @author onehao
 *
 */

public class MapTest2
{
	public static void main(String[] args)
	{
		HashMap map = new HashMap();
		
		map.put("a", "zhangsan");
		map.put("b", "zhangsan");
		
//		map.put("c", new String("zhangsan"));
		
		System.out.println(map);
		
	}
}
