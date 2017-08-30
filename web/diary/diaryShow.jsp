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
<div class="data_list">
    <div class="data_list_title">
        <img src="<%=homePath%>/picture/mainTemp/diary_show_icon.png"/>
        文章信息
    </div>
    <div>
        <div class="diary_title">
            <h2>${diary.title}</h2>
        </div>
        <div class="diary_info">发布时间:
            『<fmt:formatDate value="${diary.release_date}" type="date"
                             pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>』
            &nbsp;&nbsp;文章类别:${diary.typeName}
        </div>
        <div class="diary_content">
            ${diary.content}
        </div>
        <div class="diary_action">
            <button type="button" class="btn btn-primary" onclick="javascript:window.location.href='/ShowServlet?action=update&diaryIdParam=${diary.diaryId}'">修改文章</button>
            <button type="button" class="btn btn-primary" onclick="javascript:window.location.href='/MainServlet?flag=searchAll'">返回</button>
            <button type="button" class="btn btn-danger" onclick="VerifyDelete(${diary.diaryId})">删除文章</button>
        </div>
    </div>

</div>