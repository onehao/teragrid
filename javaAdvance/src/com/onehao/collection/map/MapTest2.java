package com.onehao.collection.map;

import java.util.HashMap;

/**
 * Map��ӳ�䣩��Map��keySet()�����᷵��key�ļ��ϣ�
 * ��ΪMap�ļ��ǲ����ظ��ģ����keySet()�����ķ���������Set����Map��ֵ�ǿ����ظ��ģ�
 * ���values()�����ķ���������Collection�����������ظ���Ԫ�ء�
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
