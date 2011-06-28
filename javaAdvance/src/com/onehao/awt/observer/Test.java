package com.onehao.awt.observer;

public class Test
{
	public static void main(String[] args)
	{
		Watched girl = new ConcreteWatched();//�൱�ڰ�ť
		
		Watcher watcher1 = new ConcreteWatcher();//�൱�ڼ�����
		Watcher watcher2 = new ConcreteWatcher();
		Watcher watcher3 = new ConcreteWatcher();
		
		girl.addWatcher(watcher1);
		girl.addWatcher(watcher2);
		girl.addWatcher(watcher3);
		
		girl.notifyWatchers("happy, cool"); //�൱�ڵ����ť
		
		girl.removeWatcher(watcher2); 
		
		girl.notifyWatchers("unhappy---");
	}
}
