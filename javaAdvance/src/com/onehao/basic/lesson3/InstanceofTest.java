package com.onehao.basic.lesson3;
/**
 * 
 * @author onehao
 *
 *15. instanceof�� �ж�ĳ�������Ƿ���ĳ�����ʵ�����﷨��ʽ��
 *	������ instanceof �������ӿ�����������һ��booleanֵ��
 *	16. People people = new Man();
 *	17. System.out.println(people instanceof People); 
 *  //���Ϊtrue����ΪMan��People�����࣬���ݼ̳У�������Ǹ��࣬���ManҲ���Կ�����People��ʵ����
 */

public class InstanceofTest
{
	public static void main(String[] args)
	{
		People people = new Man();

		System.out.println(people instanceof People);
	}
}

class People
{

}

class Man extends People
{

}
