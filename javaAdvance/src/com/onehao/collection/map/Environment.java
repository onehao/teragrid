package com.onehao.collection.map;

/**
 * Ctrl + T �鿴ʵ����
 * 
 * 
 * 
 * ����ģʽ��ȱ��
 *	�C1.�ͻ��˱���֪�����еĲ����࣬�����о���ʹ����һ�������ࡣ
 *	�C2.��ɺܶ�Ĳ����ࡣ
 *	
 * �������
 *	�C���ù�������
 * @author onehao
 *
 */
public class Environment
{
	private Strategy strategy;
	
	
	public void setStrategy(Strategy strategy)
	{
		this.strategy = strategy;
	}

	public Environment(Strategy strategy)
	{
		this.strategy = strategy;
	}
	
	public Strategy getStrategy()
	{
		return this.strategy;
	}
	
	public int calculate(int a, int b)
	{
		return strategy.calulate(a, b);
	}
	
}
