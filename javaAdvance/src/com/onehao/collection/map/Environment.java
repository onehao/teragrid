package com.onehao.collection.map;

/**
 * Ctrl + T 查看实现类
 * 
 * 
 * 
 * 策略模式的缺点
 *	–1.客户端必须知道所有的策略类，并自行决定使用哪一个策略类。
 *	–2.造成很多的策略类。
 *	
 * 解决方案
 *	–采用工厂方法
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
