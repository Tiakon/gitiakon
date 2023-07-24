<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/publicVariables.jsp" %>
<% System.out.println("**************diaryList.jsp"); %>
<jsp:useBean id="pageCode" scope="request" type="java.lang.String"/>
<jsp:useBean id="diaryList" scope="request" type="java.util.List"/>
<div class="article-box">
    <div class="article-box-title">
        <%--<img src="/picture/mainTemp/list_icon.png"/>--%>
        <span class="glyphicon glyphicon-th-list"></span>
        文章列表
    </div>
    <div class="article-box-content">
        <table class="table table-striped">
            <c:forEach var="diary" items="${diaryList}">
                <tr>
                    <td style="width: 25%;">
                        <fmt:formatDate value="${diary.release_date}" type="date" pattern="yyyy-MM-dd"></fmt:formatDate>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/ShowServlet?action=show&diaryIdParam=${diary.diaryId}">${diary.title}</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <nav class="text-center">
        <ul class="pagination">
            ${pageCode}
        </ul>
    </nav>
</div>