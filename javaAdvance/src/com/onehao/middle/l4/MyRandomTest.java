package com.onehao.middle.l4;

import java.util.Arrays;
import java.util.Random;


/**
 * �������50�����֣���������ÿ�����ֵķ�Χ��[10, 50]��
 * ͳ��ÿ�����ֳ��ֵĴ����Լ����ִ����������������ĸ�����
 * ���ÿ�����ּ�����ִ�����ӡ���������ĳ�����ֳ��ִ���Ϊ0����Ҫ��ӡ������ӡʱ�������ֵ��������С�
 * 
 * �����μ�RamdonTest2.java
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
			a[i] = r.nextInt(40) + 10;// Ӧ����41
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
		
		System.out.println("���ִ������������ǣ�" + m + " �����ǣ� " + c[40]);
		
		for(int i = 0; i < b.length; i++)
		{
			if(b[i] != 0)
			{
				System.out.println(i+10 + "  num:" + b[i]);
			}
		}
		
	}
}
