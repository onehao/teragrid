package com.onehao.middle.l4;

import java.util.Arrays;
import java.util.Random;


/**
 * 随机生成50个数字（整数），每个数字的范围是[10, 50]，
 * 统计每个数字出现的次数以及出现次数最多的数字与它的个数，
 * 最后将每个数字及其出现次数打印出来，如果某个数字出现次数为0，则不要打印它。打印时按照数字的升序排列。
 * 
 * 样例参见RamdonTest2.java
 * 
 * @author onehao
 *
 */
public class MyRandomTest {

	public static void main(String[] args) {
		
		Random r = new Random();
		int[] a = new int[50];
		for(int i = 0; i < a.length; i++)
		{
			a[i] = r.nextInt(40) + 10;// 应该是41
		}
		
//		Arrays.sort(a);
		
		int[] b = new int[41];
		for(int i = 0; i < 41; i++)
		{
			b[i] = 0;
			for(int j = 0; j < a.length; j++)
			{
				if(i == a[j]-10)
				{
					b[i]++;
				}
			}
		}
		
		int[] c = new int[41];
		System.arraycopy(b, 0, c, 0, b.length);
		Arrays.sort(c);
		int m = 0;
		for(int i = 0; i < b.length; i++)
		{
			if(c[40] == b[i])
			{
				m = i + 10;
			}
		}
		
		System.out.println("出现次数最多的数字是：" + m + " 个数是： " + c[40]);
		
		for(int i = 0; i < b.length; i++)
		{
			if(b[i] != 0)
			{
				System.out.println(i+10 + "  num:" + b[i]);
			}
		}
		
	}
}
