package com.itcast.interceptor.proxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {
	public static Object getProxy(Object obj){
		//����Ĵ�����
		ProxyHandler handler = new ProxyHandler();
		//��ʵ���и����������
		handler.setTarget(obj);
		return Proxy.newProxyInstance(UsbImpl.class.getClassLoader(), obj.getClass().getInterfaces(), handler);
	}

}
