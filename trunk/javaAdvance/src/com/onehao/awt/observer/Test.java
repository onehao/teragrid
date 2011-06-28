package com.onehao.awt.observer;

public class Test
{
	public static void main(String[] args)
	{
		Watched girl = new ConcreteWatched();//相当于按钮
		
		Watcher watcher1 = new ConcreteWatcher();//相当于监听器
		Watcher watcher2 = new ConcreteWatcher();
		Watcher watcher3 = new ConcreteWatcher();
		
		girl.addWatcher(watcher1);
		girl.addWatcher(watcher2);
		girl.addWatcher(watcher3);
		
		girl.notifyWatchers("happy, cool"); //相当于点击按钮
		
		girl.removeWatcher(watcher2); 
		
		girl.notifyWatchers("unhappy---");
	}
}
