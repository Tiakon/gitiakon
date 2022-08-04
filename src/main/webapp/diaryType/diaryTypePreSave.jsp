<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/publicVariables.jsp" %>
<% System.out.println("**************diaryTypePreSave.jsp"); %>
<div class="data-list">
    <div class="data-list-title">
        <c:choose>
            <c:when test="${diary.diaryId!=null}">
                <img src="/picture/mainTemp/diary_type_edit_icon.png"/>
                修改文章
            </c:when>
            <c:otherwise>
                <img src="/picture/mainTemp/diary_add_icon.png"/>
                写文章
            </c:otherwise>
        </c:choose>
    </div>
    <div>
        <form role="form" action="/ShowServlet?action=save" method="post" onsubmit="javascript:return VerifySave()">
            <input type="hidden" value="${diary.diaryId}" name="diaryIdInput">
            <div class="input-group">
                <span class="input-group-addon">标题</span>
                <input id="titleInput" type="text" name="titleInput" value="${diary.title}" class="form-control"
                       placeholder="请添加标题">
            </div>

            <div class="data-content">
                <textarea id="contentInput" name="contentInput" class="ckeditor">${diary.content}</textarea>
            </div>

            <div class="data-type">
                <select name="diaryTypeIdInput" id="typeIdInput">
                    <option value="-1">请选择文章类别...</option>
                    <c:forEach var="diaryType" items="${diaryTypeList}">
                        <option value="${diaryType.diaryTypeID}" ${diaryType.diaryTypeID==diary.typeId?"selected":""}>${diaryType.typeName}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="diary_button">
                <button type="submit" class="btn btn-primary" >保存</button>
                <button type="button" class="btn btn-primary"
                        onclick="javascript:window.location.href='/MainServlet?flag=searchAll'">返回
                </button>
                <p id="error"
                   style="display: inline-block; color: #ce4f4d;padding-left: 46px;">${error==null?"":error}</p>
            </div>
        </form>
    </div>

</div>
