package com.onehao.io.decorator;
public class Decorator implements Component
{
	private Component component;
	
	public Decorator(Component component)
	{
		this.component = component;
	}
	
	@Override
	public void doSomething()
	{
		component.doSomething();
	}
}
