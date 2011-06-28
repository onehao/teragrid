package com.onehao.awt.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题角色：在具体主题内部状态改变时，给所有登记过的观察者发出通知。
 * 具体主题角色通常用一个子类实现。
 * @author onehao
 *
 */
public class ConcreteWatched implements Watched
{
	private List<Watcher> list = new ArrayList<Watcher>();
	
	@Override
	public void addWatcher(Watcher watcher)
	{
		list.add(watcher);
	}

	@Override
	public void removeWatcher(Watcher watcher)
	{
		list.remove(watcher);
	}

	@Override
	public void notifyWatchers(String str)
	{
		for(Watcher w : list)
		{
			w.update(str);
		}
	}

}
