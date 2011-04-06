<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
 <s:debug/>
 <s:fielderror></s:fielderror>
 <hr>
 <s:actionerror></s:actionerror>
请登录<br>
<s:form action="login!dealLogin.action" namespace="/Login">
<s:textfield label="用户名" name="username"></s:textfield>
<s:password label="密码" name="pass"></s:password>
<s:submit value="登录"></s:submit>
</s:form>
</body>
</html>