package com.itcast.action;

public class LoginAction {
	//�û���
	private String username;
	
	//����
	private String pass;
	
	//�����¼ҳ��
	public String login(){
		return "input";
	}
	
	//�����¼����
	public String dealLogin(){
		if("ddd".equals(username)&&"sss".equals(pass)){
			System.out.println("������ȷ��¼�ɹ�");
		return "success";
		}
		System.out.println("���벻��ȷ����¼ʧ��");
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
