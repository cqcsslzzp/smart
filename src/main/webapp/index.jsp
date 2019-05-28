<%--
  Created by IntelliJ IDEA.
  User: zuping.zhang
  Date: 2019/5/27
  Time: 下午 02:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page language="java" contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>论坛登陆界面</title>
</head>
<body>
    <c:if test="${!empty error}">
        <font color="red"><c:out value="${error}"/> </font>
    </c:if>
<from action = "<c:url value="/loginCheck.jsp" />" method="post">
    用户名：<input type="text" name="userName">
    <br>
    密码：<input type="text" name="password" >
    <br>
    <input type="submit" value="登陆" />
    <input type="submit" value="重置" />


</from>
</body>
</html>
