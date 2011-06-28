package com.onehao.awt.observer;

/**
 * 抽象观察者角色：为所有具体的观察者定义一个接口，在得到主题的通知时更新自己。
 * 
 * @author onehao
 *
 */
public interface Watcher
{
	public void update(String str);
}
