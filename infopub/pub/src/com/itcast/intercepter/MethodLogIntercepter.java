package com.itcast.intercepter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * ָ�����˷�����������
 * @author onehao
 *
 */
public class MethodLogIntercepter extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		String result = "";
		System.out.println("�û���¼ϵͳ������actionǰ.......");
		result = invocation.invoke();
		System.out.println("�û���¼ϵͳ������action��-------");
		return null;
	}

}
