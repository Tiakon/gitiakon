<%--
  Created by IntelliJ IDEA.
  User: Hoictas
  Date: 2017/8/18
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Hoictas
  Date: 2017/8/10
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/publicVariables.jsp" %>
<% System.out.println("**************diaryShow.jsp"); %>
<div class="data-list">
    <div class="data-list-title">
        <img src="<%=homePath%>/picture/mainTemp/diary_show_icon.png"/>
        阅读文章
    </div>
    <div>
        <div class="data-title">
            <h2>${diary.title}</h2>
        </div>
        <div class="data-info">
            <span class="glyphicon glyphicon-time"></span>&nbsp;
            <fmt:formatDate value="${diary.release_date}" type="date"
                            pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
            &nbsp;&nbsp;<span class="glyphicon glyphicon-tag"></span>&nbsp;${diary.typeName}
        </div>
        <div class="data-content">
            ${diary.content}
        </div>
        <div class="data-action">
            <button type="button" class="btn btn-primary"
                    onclick="javascript:window.location.href='/ShowServlet?action=update&diaryIdParam=${diary.diaryId}'">
                &nbsp;修改文章&nbsp;
            </button>&nbsp;
            <button type="button" class="btn btn-default"
                    onclick="javascript:window.location.href='/MainServlet?flag=searchAll'">&nbsp;返回&nbsp;
            </button>&nbsp;
            <button type="button" class="btn btn-danger" onclick="VerifyDelete(${diary.diaryId})">&nbsp;删除文章&nbsp;
            </button>
        </div>
    </div>

</div>