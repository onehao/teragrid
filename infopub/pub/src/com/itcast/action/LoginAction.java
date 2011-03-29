package com.itcast.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	//用户名
	private String username;
	
	//密码
	private String pass;
	
	//请求登录页面
	public String login(){
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
