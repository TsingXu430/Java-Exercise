<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>注册</h1>
<p style="color:red;font-weight:900">${msg }</p>
<%--${pageContext.request.contextPath} --%>
<form action="<c:url value='/RegisterServlet'/>" method="post">
	用户名:<input type="text" name="username" /><br/>
	密码:<input type="password" name="password" /><br/>
	<input type="submit" value="注册" />
</form>
</body>
</html>