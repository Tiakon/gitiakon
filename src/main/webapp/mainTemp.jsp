<%--
  Created by IntelliJ IDEA.
  User: Hoictas
  Date: 2017/8/8
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="publicVariables.jsp" %>
<%System.out.println("**************mainTemp.jsp");%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="Tiakon">
    <link rel="icon" href="<%=homePath%>/picture/favicon.ico">
    <title>Taikon's Blog</title>
    <!-- Bootstrap core CSS -->
    <link href="<%=homePath%>/css/bootstrap.css" rel="stylesheet">
    <!-- Blog core CSS -->
    <link href="<%=homePath%>/css/blog.css" rel="stylesheet">
    <!--jquery-->
    <script src="<%=homePath%>/js/jquery-3.1.0.min.js"></script>
    <!--bootstrap-->
    <script src="<%=homePath%>/js/bootstrap.min.js"></script>
    <!--Js Tool File-->
    <script src="<%=homePath%>/js/utils.js"></script>
    <!--editor.md plugins -->
    <link href="<%=homePath%>/js/editor.md/css/editormd.css" rel="stylesheet" type="text/css"/>
    <link href="<%=homePath%>/js/editor.md/css/editormd.preview.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<%--当桌面像素大于992px时,导航栏处使用此显示方案--%>
<nav class="navbar navbar-inverse navbar-fixed-top hidden-xs hidden-sm">
    <div class="container-fluid container-fluid-mod-1">
        <div class="row row-mod">
            <div class="col-md-1"></div>
            <div class="col-md-1.5">
                <div class="navbar-header">
                    <a class="navbar-brand activate " href="/MainServlet?flag=searchAll" style="color: #ffffff;">Tiakon's
                        Blog</a>
                </div>
            </div>
            <div class="col-md-1.5 navbar-form navbar-left">
                <form action="/MainServlet?flag=searchAll" method="post"
                      role="form">
                    <div class="form-group">
                        <input type="search" name="search" style="font-style: italic;" class="form-control"
                               placeholder="搜索博文...">
                    </div>
                </form>
            </div>
            <div class="col-md-3 col-lg-offset-2 collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="/ShowServlet?action=presave">
                            <i class="glyphicon glyphicon-pencil"></i>&nbsp;编辑文章
                        </a>
                    </li>
                    <li>
                        <a href="/DiaryTypeServlet?action=list">
                            <i class="glyphicon glyphicon-tag"></i>&nbsp;标签管理
                        </a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button">
                            &nbsp;<i class="glyphicon glyphicon-plus"></i>扩展功能
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <i class="caret caret-mod"></i>
                            <li><a href="#">扩展功能1</a></li>
                            <li><a href="#">扩展功能2</a></li>
                            <li><a href="#">扩展功能3</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">扩展功能4</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">扩展功能5</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="col-md-1 col-lg-offset-1 col-md-offset-1 collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"
                           role="button"><i class="glyphicon glyphicon-user"></i>&nbsp;个人中心
                            <span class="caret"></span>
                        </a>

                        <ul class="dropdown-menu">
                            <i class="caret caret-mod"></i>
                            <li><a href="/UserServlet?action=presave">用户信息</a></li>
                            <li><a href="#">其它功能1</a></li>
                            <li><a href="#">其它功能2</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="/UserServlet?action=safeExit">安全退出</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="col-md-1"></div>
        </div>
    </div>
</nav>

<%--当桌面像素小于992px时,导航栏处使用此显示方案--%>
<div class="mobile-menu-area hidden-md hidden-lg">
    <nav class="navbar navbar-inverse navbar-static-top">
        <div class="container-fluid  text-center">
            <div class="navbar-title">
                <a href="#" class="logo-style">Tiakon's Blog</a>
            </div>
            <form action="/MainServlet?flag=searchAll" method="post" class="navbar-form" role="search">
                <div class="form-group center-block">
                    <input type="search" name="search" style="font-style: italic;" class="form-control"
                           placeholder="搜索博文...">
                    <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i>
                    </button>
                </div>
            </form>

            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingOne">
                        <h4 class="panel-title pull-left">
                            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                               aria-expanded="true" aria-controls="collapseOne">
                                <i class="glyphicon glyphicon-menu-hamburger" style="font-size: 25px;"
                                   aria-hidden="true"></i>
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="headingOne">
                        <div class="panel-body">
                            <div class="row">
                                <ul class="nav nav-tabs text-center">
                                    <li class="col-xs-12 col-sm-12" role="presentation"><a
                                            href="/MainServlet?flag=searchAll">主页</a></li>
                                    <li class="col-xs-12 col-sm-12" role="presentation"><a
                                            href="/ShowServlet?action=presave">写博客</a></li>
                                    <li class="col-xs-12 col-sm-12" role="presentation"><a
                                            href="/DiaryTypeServlet?action=list">标签管理</a></li>
                                    <li class="col-xs-12 col-sm-12" role="presentation"><a
                                            href="/UserServlet?action=presave">用户信息</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</div>

<%--博客内容--%>
<div class="container-fluid container-fluid-mod-2">
    <c:choose>
        <c:when test="${flag=='success'}">
            <div class="row row-mod" id="success">
                <div class="col-md-1"></div>
                <div class="col-xs-12 col-md-10 alert alert-success alert-dismissible text-center" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <strong><c:out value="${message}"/></strong>
                </div>
                <div class="col-md-1"></div>
            </div>
        </c:when>
        <c:when test="${flag=='failure'}">
            <div class="row row-mod" id="failure">
                <div class="col-md-1"></div>
                <div class="col-xs-12 col-md-10 alert alert-danger alert-dismissible text-center" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <strong>${message}</strong>
                </div>
                <div class="col-md-1"></div>
            </div>
        </c:when>
    </c:choose>
    <div class="row row-mod">
        <div class="col-md-1"></div>
        <div id="userError" class="col-xs-12 col-md-10 alert alert-danger text-center user-error" role="alert">
            昵称或心情不能为空！
        </div>
        <div class="col-md-1"></div>
    </div>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-xs-12 col-md-7">
            <jsp:include page="${mainPage==null?'mainPageIsNull.jsp':mainPage}" flush="true"></jsp:include>
        </div>
        <div class="col-xs-12 col-md-3">
            <%--个人信息展示板--%>
            <div class="data-list">
                <%--<div class="data-list-title">--%>
                <%--<img src="<%=homePath%>/picture/mainTemp/user_icon.png"/>--%>
                <%--<sapn class="glyphicon glyphicon-user"></sapn>&nbsp;个人中心--%>
                <%--</div>--%>
                <div class="user-content">
                    <img class="img-rounded" style="width: 100%;" src="${currentUser.imageName}" alt="${currentUser.nickName}的头像"/>
                    <div class="user-nickName">${currentUser.nickName}</div>
                    <div class="user-mood">${currentUser.mood}</div>
                </div>
            </div>
            <%--按照日期查看文章--%>
            <div class="data-list">
                <div class="data-list-title">
                    <%--<img src="<%=homePath%>/picture/mainTemp/list_icon.png"/>--%>
                    <span class="glyphicon glyphicon-calendar"></span>&nbsp;时间列表
                </div>
                <div class="data-datas-content">
                    <ul>
                        <c:forEach var="diaryDate" items="${diaryDateList}">
                            <li>
                                <a href="/MainServlet?diaryDateParam=${diaryDate.release_dateStr}"><span>${diaryDate.release_dateStr}</span>(${diaryDate.diaryDateCount})</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <%--按照标签查看文章--%>
            <div class="tags-box">
                <div class="tags-title">
                    <%--<img src="<%=homePath%>/picture/mainTemp/byType_icon.png"/>--%>
                    <sapn class="glyphicon glyphicon-tags"></sapn>&nbsp;便签云
                </div>
                <div class="tags-content">
                    <ul>
                        <c:forEach var="diaryType" items="${diaryTypeCountList}">
                            <li>
                                <a href="/MainServlet?diaryTypeIDParam=${diaryType.diaryTypeID}">${diaryType.typeName}<span
                                        class="badge">${diaryType.diaryTypeCount}</span></a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<%--博客页脚--%>
<div class="navbar-static-bottom"><%--   footer text-center --%>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-1 col-md-1"></div>
            <div class="col-md-2 col-lg-2">备案号:京ICP备16054569号</div>
            <div class="col-md-offset-2 col-md-4 col-lg-offset-2 col-lg-4">Copyright &copy; 2017 Powered by Tiakon</div>
            <div class="col-lg-1"></div>
        </div>
    </div>
</div>

<script src="<%=homePath%>/js/jquery-3.1.0.min.js"></script>
<script src="<%=homePath%>/js/editor.md/lib/marked.min.js"></script>
<script src="<%=homePath%>/js/editor.md/lib/prettify.min.js"></script>
<script src="<%=homePath%>/js/editor.md/lib/raphael.min.js"></script>
<script src="<%=homePath%>/js/editor.md/lib/underscore.min.js"></script>
<script src="<%=homePath%>/js/editor.md/lib/sequence-diagram.min.js"></script>
<script src="<%=homePath%>/js/editor.md/lib/flowchart.min.js"></script>
<script src="<%=homePath%>/js/editor.md/lib/jquery.flowchart.min.js"></script>
<script src="<%=homePath%>/js/editor.md/js/editormd.js"></script>

<script src="<%=homePath%>/js/mainTemp.js" type="text/javascript"></script>

</body>
</html>