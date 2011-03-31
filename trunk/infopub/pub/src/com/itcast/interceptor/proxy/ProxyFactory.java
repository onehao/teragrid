package com.itcast.interceptor.proxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {
	public static Object getProxy(Object obj){
		//代理的处理类
		ProxyHandler handler = new ProxyHandler();
		//将实例托付给代理操作
		handler.setTarget(obj);
		return Proxy.newProxyInstance(UsbImpl.class.getClassLoader(), obj.getClass().getInterfaces(), handler);
	}

}
