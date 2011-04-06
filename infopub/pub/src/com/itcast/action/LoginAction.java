package com.itcast.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	//用户名
	private String username;
	
	//密码
	private String pass;
	
	//请求登录页面
	public String login(){
		System.out.println("调用LoginAction中的login方法");
		return "input";
	}
	
	//处理登录请求
	public String dealLogin(){
		if("ddd".equals(username)&&"sss".equals(pass)){
			System.out.println("密码正确登录成功");
		return "success";
		}
		System.out.println("密码不正确，登录失败");
		HttpServletRequest req = ServletActionContext.getRequest();
		System.out.println("username from request[" + req.getParameter("username") +"]");
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
		System.out.println("session's username is ["+ session.getAttribute("username")+"]");
		Map sessionMap = ActionContext.getContext().getSession();
		sessionMap.put("username", "change the username");
		System.out.println("session's username is ["+ session.getAttribute("username")+"]");
		Map applicationMap = ActionContext.getContext().getApplication();
		
		return "error";
	}
	
	//action默认调用函数
	public String execute(){
		System.out.println("调用execute");
		return "error";
	}
	
	//使用validate进行验证
	public void validate(){
		System.out.println("调用validate");
		if("ddd".equals(username)&&"sss".equals(pass)){
			addFieldError("username","用户名不能为ddd,密码不能为sss");
			addActionError("addActionError用户名不能为ddd,密码不能为sss");
		}
	}
	
	//使用validateMethodName进行验证
	public void validateDealLogin()
	{
		System.out.println("调用validateDealLogin");
		if("ddd".equals(username)&&"sss".equals(pass)){
			addFieldError("username","用户名不能为ddd,密码不能为sss");
			addActionError("addActionError用户名不能为ddd,密码不能为sss");
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
