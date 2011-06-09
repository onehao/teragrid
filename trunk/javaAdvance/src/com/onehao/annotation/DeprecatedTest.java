package com.onehao.annotation;

import java.util.Date;

public class DeprecatedTest {
	
	@Deprecated
	public void doSomething(){
		System.out.println("do something!");
	}
	
	public static void main(String[] args) {
		DeprecatedTest test = new DeprecatedTest();
		
		test.doSomething();
	}
}
