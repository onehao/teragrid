package com.onehao.awt.observer;

/**
 * ����۲��߽�ɫ���ý�ɫʵ�ֳ���۲��߽�ɫ��Ҫ��ĸ��½ӿڣ�
 * �Ա�ʹ�����״̬�������״̬��Э���������Ҫ��
 * ����۲��߽�ɫ���Ա���һ��ָ����������ɫ�����á�
 * ͨ����һ������ʵ��
 * 
 * @author onehao
 *
 */

public class ConcreteWatcher implements Watcher
{

	@Override
	public void update(String str)
	{
		System.out.println(str);
	}

}
