<%--
  Created by IntelliJ IDEA.
  User: Hoictas
  Date: 2017/8/8
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.tiakon.entity.User" %>
<%@include file="publicVariables.jsp" %>
<%
    System.out.println("**************login.jsp");

    //检查客户端是否有cookie信息，有则显示在文本框中
    if (request.getAttribute("user") == null) {
        String userName = null;
        String password = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if ("user".equals(cookies[i].getName())) {
                    String[] users = cookies[i].getValue().split("-");
                    userName = users[0];
                    password = users[1];
                }
            }
        }
        if (userName == null) {
            userName = "";
        }
        if (password == null) {
            password = "";
        }
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        pageContext.setAttribute("user", user);
    }
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Tiakon's Blog</title>
    <!-- Bootstrap -->
    <link href="<%=homePath%>/picture/favicon.ico" rel="icon">
    <link href="<%=homePath%>/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="<%=homePath%>/css/login.css" rel="stylesheet" type="text/css">
    <link href="<%=homePath%>/css/checked.min.css" rel='stylesheet' type='text/css'/>
    <script src="<%=homePath%>/js/jquery-3.1.0.min.js" type="text/javascript"></script>
    <script src="<%=homePath%>/js/bootstrap.js" type="text/javascript"></script>
    <script src="<%=homePath%>/js/utils.js" type="text/javascript"></script>
</head>
<body>
<div class="container-fluid">
    <form action="<%=homePath%>/LoginServlet" onsubmit="javascript:return VerifyLogin();" class="form-signin"
          method="post" role="form">
        <h2 class="form-signin-heading">Tiakon博客系统</h2>

        <div class="form-group">
            <label for="inputUserName" class="sr-only">用户名</label>
            <input type="text" id="inputUserName" name="username" class="form-control" value="${user.userName}"
                   placeholder="用户名">
        </div>
        <div class="form-group">
            <label for="inputPassword" class="sr-only">密码</label>
            <input type="password" id="inputPassword" name="password" class="form-control" value="${user.password}"
                   placeholder="密码">
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" class="checked-boom" name="remember" value="remember-me"> 记住我
                <p id="error"
                   style="display: inline-block; color: #a94442;padding-left: 46px;">${error==null?"":error}</p>
            </label>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">登 录</button>
    </form>
</div>
<script src="<%=homePath%>/js/login.js" type="text/javascript"></script>
</body>
</html>

