<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/publicVariables.jsp" %>
<% System.out.println("**************diaryShow.jsp");%>
<div class="data-list">
    <div class="data-list-title">
        <c:choose>
            <c:when test="${diary.diaryId!=null}">
                <img src="${pageContext.request.contextPath}/picture/mainTemp/diary_type_edit_icon.png"/>
                修改文章
            </c:when>
            <c:otherwise>
                <img src="${pageContext.request.contextPath}/picture/mainTemp/diary_add_icon.png"/>
                编辑文章
            </c:otherwise>
        </c:choose>
    </div>
    <div>
        <form role="form" action="${pageContext.request.contextPath}/ShowServlet?action=save" method="post" onsubmit="return VerifySave()">
            <input type="hidden" value="${diary.diaryId}" name="diaryIdInput">
            <div class="input-group">
                <span class="input-group-addon">标题</span>
                <input id="titleInput" type="text" name="titleInput" value="${diary.title}" class="form-control"
                       placeholder="请添加标题">
            </div>

            <%--
            <div class="data-content">
                <textarea id="contentInput" name="contentInput" class="ckeditor">${diary.content}</textarea>
            </div>
            --%>

            <div id="my-editormd">
                <textarea id="my-editormd-markdown-doc" class="editormd-markdown-textarea"
                          name="contentInput" style="display:none;" >${diary.content}</textarea>
                <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
                <!-- html textarea 需要开启配置项 saveHTMLToTextarea == true -->
                <textarea id="my-editormd-html-code" class="editormd-html-textarea"
                          name="my-editormd-html-code" style="display:none;">${diary.content}</textarea>
            </div>

            <div class="data-type">
                <select name="diaryTypeIdInput" id="typeIdInput">
                    <option value="-1">请选择文章类别...</option>
                    <c:forEach var="diaryType" items="${diaryTypeCountList}">
                        <option value="${diaryType.diaryTypeID}" ${diaryType.diaryTypeID==diary.typeId?"selected":""}>${diaryType.typeName}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="diary_button">
                <button type="submit" class="btn btn-primary btn-sm">&nbsp;保存&nbsp;</button>
                <button type="button" class="btn btn-default btn-sm"
                        onclick="javascript:window.location.href='/MainServlet?flag=searchAll'">&nbsp;返回&nbsp;
                </button>
                <p id="error"
                   style="display: inline-block; color: #ce4f4d;padding-left: 46px;">${error==null?"":error}</p>
            </div>
        </form>
    </div>

</div>
