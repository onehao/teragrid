package com.onehao.jdk5.staticimport;

import static com.onehao.jdk5.staticimport.common.Common.AGE;
import static com.onehao.jdk5.staticimport.common.Common.output;

/**
 * ��̬���룺
 *	a) import static com.shengsiyuan.common.Common.Age;
 *	b) import static com.shengsiyuan.common.Common.output;
 *	
 *	��ʾ����Common���еľ�̬��Ա����AGE�Լ���̬����output��
 *  ע�⣺ʹ��import staticʱ��Ҫһֱ���뵽���еľ�̬��Ա������̬������
 *  
 *  ���ȵ�ʹ��������Իή�ʹ���Ŀɶ���
 * @author onehao
 *
 */
public class StaticImportTest
{
	public static void main(String[] args)
	{
		int a = AGE;
	
		System.out.println(a);
	
		output();
	}
	
}
