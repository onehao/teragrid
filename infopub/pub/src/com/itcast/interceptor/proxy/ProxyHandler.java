package com.itcast.interceptor.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

	//被代理的对象
	private Object target;
	
	public void setTarget(Object target) {
		this.target = target;
	}

	WriteIntercepter writeIntercepter = new WriteIntercepter();
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		Object result = null;
		if(method.getName().equals("writeData")){
			writeIntercepter.methodAaa();
			result = method.invoke(target, args);
			writeIntercepter.methodBbb();
		}
		return result;
	}

}
