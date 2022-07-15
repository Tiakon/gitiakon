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
<% System.out.println("**************diaryTypeList.jsp"); %>
<% int index = 0;%>
<div class="data-list">
    <div class="data-list-title">
        <img src="<%=homePath%>/picture/mainTemp/list_icon.png"/>
        标签列表
        <button type="button" style="margin-top: -8px;" class="btn btn-info btn-sm pull-right"
                data-toggle="modal" data-target=".bs-example-modal-lg">
            增加标签
        </button>
        <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel0">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <form role="form" action="/DiaryTypeServlet?action=save" method="post"
                          onsubmit="javascript:return VerifyForm('diaryTypeName','diayTypeError');">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myLargeModalLabel0">增加标签</h4>
                        </div>
                        <div class="modal-body">
                            <div class="input-group">
                                <span class="input-group-addon" id="sizing-addon1">标签名称</span>
                                <input id="diaryTypeName" name="diaryTypeNameInput" type="text" class="form-control"
                                       placeholder="请输入标签名称" aria-describedby="sizing-addon1">
                            </div>
                        </div>
                        <div id="diayTypeError" class="text-center text-danger diayTypeError">标签名称不能为空</div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary">保存</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <table class="table table-hover">
            <tr>
                <th>编号</th>
                <th style="width: 60%">标签名称</th>
                <th>操作</th>
            </tr>
            <c:forEach var="diaryType" items="${diaryTypeCountList}">
                <tr>
                    <td><%=++index%>
                    </td>
                    <td>${diaryType.typeName}</td>
                    <td>
                        <button type="button" style="" class="btn btn-primary btn-sm"
                                data-toggle="modal" data-target="#myModal<%=index%>">
                            &nbsp;修改&nbsp;
                        </button>
                        <div class="modal fade" id="myModal<%=index%>" tabindex="-1" role="dialog"
                             aria-labelledby="myLargeModalLabel">
                            <div class="modal-dialog modal-lg" role="document">
                                <div class="modal-content">
                                    <form role="form" action="/DiaryTypeServlet?action=save" method="post"
                                          onsubmit="javascript:return VerifyForm('diaryTypeNameUpdate<%=index%>','diayTypeError<%=index%>')">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                                    aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="myLargeModalLabel">修改标签</h4>
                                        </div>
                                        <div class="modal-body">
                                            <div class="input-group">
                                                <input id="diaryTypeIdUpdate<%=index%>" value="${diaryType.diaryTypeID}"
                                                       name="diaryTypeIdUpdate" type="hidden">
                                                <span class="input-group-addon" id="sizing-addon2">标签名称</span>
                                                <input id="diaryTypeNameUpdate<%=index%>" name="diaryTypeNameUpdate"
                                                       type="text"
                                                       class="form-control" value="${diaryType.typeName}"
                                                       placeholder="请输入标签名称" aria-describedby="sizing-addon2">
                                            </div>
                                        </div>
                                        <div id="diayTypeError<%=index%>" class="text-center text-danger diayTypeError">
                                            标签名称不能为空
                                        </div>
                                        <div class="modal-footer">
                                            <button type="submit" class="btn btn-primary">保存</button>
                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        &nbsp;&nbsp;
                        <button class="btn btn-danger btn-sm"
                                onclick="DiaryTypeDelete(${diaryType.diaryTypeCount},${diaryType.diaryTypeID})">&nbsp;删除&nbsp;
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<script type="text/javascript">
    function DiaryTypeDelete(diaryTypeCount, diaryTypeId) {
        if (diaryTypeCount == "0") {
            if (confirm("您确认要删除该类别吗?")) {
                window.location.href = '/DiaryTypeServlet?action=delete&diaryTypeIdParam=' + diaryTypeId;
                return
            }
        } else {
            alert("该标签下有文章无法删除!");
        }
    }

    function VerifyForm(InputID, errorID) {
        var InputID = document.getElementById(InputID);
        var InputIDTrim = trim(InputID.value);

        if (InputIDTrim.length == 0) {
            var diayTypeError = document.getElementById(errorID);
            diayTypeError.style.display = "block";
            setTimeout("diayTypeError.style.display = 'none';", 3000);
            return false;
        }

        return true;
    }
</script>