package com.itcast.intercepter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**日志记录**/
public class LogIntercepter extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		String result = "";
		System.out.println("用户登录系统，调用action前.......");
		result = invocation.invoke();
		System.out.println("用户登录系统，调用action后-------");
		return null;
	}

}
