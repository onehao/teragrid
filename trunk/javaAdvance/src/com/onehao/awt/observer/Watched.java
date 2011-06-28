package com.onehao.awt.observer;

/**
 * 抽象主题角色：把所有对观察者对象的引用保存在一个集合中，
 * 每个抽象主题角色都可以有任意数量的观察者。
 * 抽象主题提供一个接口，可以增加和删除观察者角色。
 * 一般用一个抽象类或接口来实现。
 * 
 * @author onehao
 *
 */
public interface Watched
{
	public void addWatcher(Watcher watcher);
	
	public void removeWatcher(Watcher watcher);
	
	public void notifyWatchers(String str);
}
