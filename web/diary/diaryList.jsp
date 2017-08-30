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
<% System.out.println("**************diaryList.jsp"); %>
<div class="data_list">
    <div class="data_list_title">
        <img src="<%=homePath%>/picture/mainTemp/list_icon.png"/>
        文章列表
    </div>
    <div class="diary_datas">
        <ul>
            <c:forEach var="diary" items="${diaryList}">
                <li>
                    『<fmt:formatDate value="${diary.release_date}" type="date" pattern="yyyy-MM-dd"></fmt:formatDate>』
                    <span>&nbsp;&nbsp;&nbsp;<a href="/ShowServlet?action=show&diaryIdParam=${diary.diaryId}">${diary.title}</a></span>
                </li>
            </c:forEach>
        </ul>
    </div>
    <nav class="text-center">
        <ul class="pagination">
            ${pageCode}
        </ul>
    </nav>
</div>