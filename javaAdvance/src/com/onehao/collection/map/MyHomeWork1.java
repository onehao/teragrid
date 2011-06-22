package com.onehao.collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
/**
 * 课程讲解参见RandomTest
 * @author onehao
 *
 */
public class MyHomeWork1
{
	public static void main(String[] args)
	{
		HashMap  map = new HashMap();
		
		List list = new ArrayList();
		
		for(int i = 0; i < 50; i++)
		{
			Random r = new Random();
			int a = r.nextInt(41) + 10;
			list.add(new Integer(a));
		}
		
		for(Iterator iter = list.iterator(); iter.hasNext();)
		{
			Integer in = (Integer)iter.next();
			if(map.get(in) == null)
				map.put(in, new Integer(1));
			else
			{
				Integer value = (Integer)map.get(in);
				value = new Integer(value.intValue() + 1);
				map.put(in, value);
			}
		}
		
		Set set = map.entrySet();
		
		int max = 0;
		
		for(Iterator iter = set.iterator(); iter.hasNext();)
		{
			Map.Entry entry = (Map.Entry)iter.next();
			
			Integer key = (Integer)entry.getKey();
			Integer value = (Integer)entry.getValue();
			
			max = max >= value.intValue()? max:value.intValue();
			
			System.out.println(key + " : " + value);
			
		}
		
		System.out.println("出现次数最多次为：" + max);
		
		for(Iterator iter = set.iterator(); iter.hasNext();)
		{
			Map.Entry entry = (Map.Entry)iter.next();
			
			if(max == ((Integer)entry.getValue()).intValue())
					System.out.println(entry.getKey());
			
			
			
		}
	}
}
