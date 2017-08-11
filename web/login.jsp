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
    System.out.println("login.jsp");


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
    <title>Tiakon's blog</title>
    <!-- Bootstrap -->
    <link rel="icon" href="<%=homePath%>/picture/favicon.ico">
    <link href="<%=homePath%>/css/bootstrap.css" rel="stylesheet">
    <link href="<%=homePath%>/css/signin.css" rel="stylesheet">
    <script src="<%=homePath%>/js/jquery-3.1.0.min.js" type="text/javascript"></script>
    <script src="<%=homePath%>/js/bootstrap.js" type="text/javascript"></script>
    <script src="<%=homePath%>/js/utils.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <form action="<%=homePath%>/LoginServlet" onsubmit="javascript:return VerifyLogin();" class="form-signin"
          method="post">
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
                <input type="checkbox" name="remember" value="remember-me"> 记住我
                <p id="error"
                   style="display: inline-block; color: #a94442;padding-left: 46px;">${error==null?"":error}</p>
            </label>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">登 录</button>
    </form>
</div>

</body>
</html>
<script>
    function VerifyLogin() {

        var inputUserName = document.getElementById("inputUserName");
        var inputPassword = document.getElementById("inputPassword");
        var error = document.getElementById("error");
        var form_group = document.getElementsByClassName("form-group");

        var username = trim(inputUserName.value);
        var password = trim(inputPassword.value);

        if (username.length == 0) {
            form_group[0].className = "form-group has-error";
            var username_label = form_group[0].firstElementChild;
            username_label.className = "control-label";
            username_label.innerHTML = "用户名不能为空";
            return false;
        } else {
            form_group[0].className = "form-group";
            var username_label = form_group[0].firstElementChild;
            username_label.className = "sr-only";
            username_label.innerHTML = "用户名";
        }
        if (password.length == 0) {
            form_group[1].className = "form-group has-error";
            var username_label = form_group[1].firstElementChild;
            username_label.className = "control-label";
            username_label.innerHTML = "密码不能为空";
            return false;
        } else {
            form_group[1].className = "form-group";
            var username_label = form_group[1].firstElementChild;
            username_label.className = "sr-only";
            username_label.innerHTML = "密码";
        }
        error.style.display = "none";
        return true;
    }
</script>
