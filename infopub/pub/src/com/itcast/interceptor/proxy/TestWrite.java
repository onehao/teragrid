package com.itcast.interceptor.proxy;

public class TestWrite {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IWrite write = new UsbImpl();
		IWrite iw= null;
		Object proxy = ProxyFactory.getProxy(write);
		if(proxy instanceof IWrite){
			iw = (IWrite)proxy;
		}
		System.out.println("一个方法");
		iw.writeData();
		System.out.println("二个方法");
		iw.writeNoDate();
	}

}
