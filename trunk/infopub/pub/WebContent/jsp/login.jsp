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
���¼<br>
<s:form action="login!dealLogin.action" namespace="/Login">
<s:textfield label="�û���" name="username"></s:textfield>
<s:password label="����" name="pass"></s:password>
<s:submit value="��¼"></s:submit>
</s:form>
</body>
</html>