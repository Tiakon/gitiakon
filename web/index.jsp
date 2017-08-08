<%--
  Created by IntelliJ IDEA.
  User: Hoictas
  Date: 2017/8/8
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String homePath = request.getContextPath();%>
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
    <script src="<%=homePath%>/js/jquery-3.1.0.min.js"></script>
    <script src="<%=homePath%>/js/bootstrap.js"></script>
    <script src="<%=homePath%>/js/utils.js"></script>

</head>
<body>
<div class="container">

    <form action="<%=homePath%>/LoginServlet" id="form-signin" class="form-signin" method="post">
        <h2 class="form-signin-heading">Tiakon博客系统</h2>
        <label for="inputUserName" class="sr-only">用户名</label>
        <input type="text" id="inputUserName" name="username" class="form-control" placeholder="用户名">
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码">
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住 我
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" onclick="javascript:return VerifyLogin();" type="submit">登 录
        </button>
    </form>
</div>
</body>
</html>
<script>
    var inputUserName = document.getElementById("inputUserName");
    var inputPassword = document.getElementById("inputPassword");

    function VerifyLogin() {
        var username = trim(inputUserName.value);
        var password = trim(inputPassword.value);

        if (username.length != 0 && password.length != 0) {
            return true;
        }
        alert("用户名或密码不能为空！");
        return false;
    }
</script>
