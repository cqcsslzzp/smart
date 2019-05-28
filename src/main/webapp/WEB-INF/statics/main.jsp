<%--
  Created by IntelliJ IDEA.
  User: zuping.zhang
  Date: 2019/5/27
  Time: 下午 02:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
    <title>刘刘论坛</title>
</head>
<body>
    <%--访问session域中User对象，显示用户和积分信息--%>
    ${user.userName},欢迎进入刘刘识论坛，您当前积分{user.credits};
</body>
</html>
