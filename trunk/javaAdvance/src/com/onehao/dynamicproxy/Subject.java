package com.onehao.dynamicproxy;

import java.util.Date;

public interface Subject {
	public void request();
	
	//add by onehao for functions with parameter
	public void requestWithParams(String name, Date date);
}
