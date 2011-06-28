package com.onehao.awt.observer;

/**
 * ���������ɫ�������жԹ۲��߶�������ñ�����һ�������У�
 * ÿ�����������ɫ�����������������Ĺ۲��ߡ�
 * ���������ṩһ���ӿڣ��������Ӻ�ɾ���۲��߽�ɫ��
 * һ����һ���������ӿ���ʵ�֡�
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
