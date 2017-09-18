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
    <meta name="author" content="Taikon">
    <link rel="icon" href="<%=homePath%>/picture/favicon.ico">
    <title>Taikon's Blog</title>
    <!-- Bootstrap core CSS -->
    <link href="<%=homePath%>/css/bootstrap.css" rel="stylesheet">
    <link href="<%=homePath%>/css/diaryStyle.css" rel="stylesheet">

    <script src="<%=homePath%>/js/jquery-3.1.0.min.js"></script>
    <script src="<%=homePath%>/js/bootstrap.min.js"></script>
    <script src="<%=homePath%>/js/ckeditor/ckeditor.js"></script>
    <script src="<%=homePath%>/js/utils.js"></script>
</head>
<body>
<%--当桌面像素大于992px时导航栏处使用此显示方案--%>
<nav class="navbar navbar-inverse navbar-fixed-top hidden-xs hidden-sm">
    <div class="container-fluid container-fluid-mod">
        <div class="row row-mod">
            <div class="col-md-1"></div>
            <div class="col-md-1.5">
                <div class="navbar-header">
                    <a class="navbar-brand activate" href="/MainServlet?flag=searchAll" >Taikon's
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
                            <i class="glyphicon glyphicon-book"></i>&nbsp;类别管理
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

<%--当桌面像素小于992px时导航栏处使用此显示方案--%>
<div class="mobile-menu-area hidden-md hidden-lg">
    <nav class="navbar navbar-inverse navbar-static-top">
        <div class="container-fluid  text-center">
            <div class="navbar-title">
                <a href="#" class="">Tiakon's Blog</a>
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
                                            href="/DiaryTypeServlet?action=list">文章分类管理</a></li>
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
<div class="container-fluid" style="margin-top: 80px;">
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
            <div class="data_list">
                <div class="data_list_title">
                    <img src="<%=homePath%>/picture/mainTemp/user_icon.png"/>
                    个人中心
                </div>
                <div class="user_content">
                    <img src="${currentUser.imageName}" alt="${currentUser.nickName}的头像"/>
                    <div class="user_nickName">${currentUser.nickName}</div>
                    <div class="user_mood">(${currentUser.mood})</div>
                </div>
            </div>
            <div class="data_list">
                <div class="data_list_title">
                    <img src="<%=homePath%>/picture/mainTemp/byType_icon.png"/>
                    按文章类别
                </div>
                <div class="data_list_content">
                    <ul>
                        <c:forEach var="diaryType" items="${diaryTypeCountList}">
                            <li>
                                <a href="/MainServlet?diaryTypeIDParam=${diaryType.diaryTypeID}"><span>${diaryType.typeName}</span>(${diaryType.diaryTypeCount})</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="data_list">
                <div class="data_list_title">
                    <img src="<%=homePath%>/picture/mainTemp/list_icon.png"/>
                    文章列表
                </div>
                <div class="data_list_content">
                    <ul>
                        <c:forEach var="diaryDate" items="${diaryDateList}">
                            <li>
                                <a href="/MainServlet?diaryDateParam=${diaryDate.release_dateStr}"><span>${diaryDate.release_dateStr}</span>(${diaryDate.diaryDateCount})</a>
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
<div class="footer text-center">
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">&copy;Copy Tiakon版权所有</div>
        <div class="col-lg-1"></div>
    </div>
</div>
</body>
</html>

<script type="text/javascript">
    //限时关闭操作提示信息
    function AutoCloseInfo() {
        var success = document.getElementById('success');
        var failure = document.getElementById('failure');

        if (success != null || failure != null) {
            setTimeout("success.style.display='none';", 3000);
        }
    }

    function VerifySave() {

        var titleInput = document.getElementById('titleInput');
        var content = CKEDITOR.instances.contentInput.getData();
        var typeIdInput = document.getElementById('typeIdInput');
        var error = document.getElementById('error');

        var title = trim(titleInput.value);

        if (title.length == 0) {
            error.innerHTML = '标题不能为空';
            return false;
        }
        if (content.length == 0) {
            error.innerHTML = '内容不能为空';
            return false;
        }
        if (typeIdInput.value == '-1') {
            error.innerHTML = '文章类别不能为空';
            return false;
        }
        return true;
    }

    function VerifyDelete(diaryIdParam) {
        if (confirm("你确定删除这篇文章？")) {
            window.location.href = '/ShowServlet?action=delete&diaryIdParam=' + diaryIdParam;
        }
    }

    AutoCloseInfo();

</script>
