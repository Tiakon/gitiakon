<%--
  Created by IntelliJ IDEA.
  User: Hoictas
  Date: 2017/8/8
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="publicVariables.jsp" %>
<%System.out.println("mainTemp.jsp");%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="Taikon">
    <link rel="icon" href="<%=homePath%>/picture/favicon.ico">
    <title>Taikon's Blog</title>
    <!-- Bootstrap core CSS -->
    <link href="<%=homePath%>/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
        .container-fluid {
            margin: 0% 5%;
        }

        .data_list {
            border: 1px solid #E5E5E5;
            padding: 10px;
            background-color: #FDFDFD;
            margin-top: 15px;
        }

        .data_list .data_list_title {
            font-size: 15px;
            font-weight: bold;
            border-bottom: 1px solid #E5E5E5;
            padding-bottom: 10px;
            padding-top: 5px;
        }

        .data_list .data_list_title img {
            vertical-align: top;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Taikon's Blog</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="#"><i class="glyphicon glyphicon-home"></i>&nbsp;主页 </a>
                </li>
                <li><a href="#"><i class="glyphicon glyphicon-pencil"></i>&nbsp;写博客</a></li>
                <li><a href="#"><i class="glyphicon glyphicon-book"></i>&nbsp;日记分类管理</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button">
                        <i class="glyphicon glyphicon-user"></i>个人中心
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>

            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="搜索博文">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">关于</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button">下拉菜单
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="container-fluid" style="margin-top: 80px;">
    <div class="row">
        <div class="col-xs-12 col-md-8">

            <jsp:include page="${mainPage==null?'mainPageIsNull.jsp':mainPage}"></jsp:include>
            <%--<jsp:include page=""></jsp:include>--%>
        </div>
        <div class="col-xs-12 col-md-4">
            <div class="data_list">
                <div class="data_list_title">
                    <img src="${pageContext.request.contextPath}/picture/mainTemp/user_icon.png"/>
                    个人中心
                </div>
            </div>

            <div class="data_list">
                <div class="data_list_title">
                    <img src="${pageContext.request.contextPath}/picture/mainTemp/byType_icon.png"/>
                    按日志类别
                </div>
            </div>

            <div class="data_list">
                <div class="data_list_title">
                    <img src="${pageContext.request.contextPath}/picture/mainTemp/list_icon.png"/>
                    日记列表
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<%=homePath%>/js/jquery-3.1.0.min.js"></script>
<script src="<%=homePath%>/js/bootstrap.min.js"></script>
</body>
</html>