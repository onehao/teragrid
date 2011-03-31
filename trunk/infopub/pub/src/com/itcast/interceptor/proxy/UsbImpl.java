package com.itcast.interceptor.proxy;

public class UsbImpl implements IWrite {

	@Override
	public void writeData() {
		// TODO Auto-generated method stub
		System.out.println("使用USB存储数据");

	}
	public void writeNoDate(){
		System.out.println("不使用USB存储数据");
	}

}
