package com.itcast.interceptor.proxy;

public class UsbImpl implements IWrite {

	@Override
	public void writeData() {
		// TODO Auto-generated method stub
		System.out.println("ʹ��USB�洢����");

	}
	public void writeNoDate(){
		System.out.println("��ʹ��USB�洢����");
	}

}
