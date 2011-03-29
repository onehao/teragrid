package com.itcast.action;

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
