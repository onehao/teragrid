package com.itcast.intercepter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**��־��¼**/
public class LogIntercepter extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		String result = "";
		System.out.println("�û���¼ϵͳ������actionǰ.......");
		result = invocation.invoke();
		System.out.println("�û���¼ϵͳ������action��-------");
		return null;
	}

}
