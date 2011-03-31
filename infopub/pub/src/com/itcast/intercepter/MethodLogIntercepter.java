package com.itcast.intercepter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 指定过滤方法的拦截器
 * @author onehao
 *
 */
public class MethodLogIntercepter extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		String result = "";
		System.out.println("用户登录系统，调用action前.......");
		result = invocation.invoke();
		System.out.println("用户登录系统，调用action后-------");
		return null;
	}

}
