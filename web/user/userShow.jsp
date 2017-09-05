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
<% System.out.println("**************userShow.jsp"); %>
<div class="data_list">
    <div class="data_list_title">
        <img src="<%=homePath%>/picture/mainTemp/user_edit_icon.png"/>
        用户信息
    </div>
    <div class="container-fluid" style="margin-top: 25px;">
        <div class="row">
            <div class="col-xs-12 col-md-4">
                <img src="${currentUser.imageName}" style="width: 100%;" class="img-circle" alt="${currentUser.userName}的头像">
            </div>
            <div class="col-xs-12 col-md-8">
                <form action="UserServlet?action=save" enctype="multipart/form-data" role="form" method="post">
                    <div class="form-group">
                        <label for="exampleInputFile">选择头像</label>
                        <input type="file" id="exampleInputFile" name="uploadFileInput">
                        <p class="help-block">这里可添加帮助文本</p>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">昵称</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" value="${currentUser.nickName}"
                               placeholder="请输入你的昵称" name="nickNameInput">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">心情</label>
                        <textarea name="moodTextArea" class="form-control" id="exampleInputPassword1"
                                  cols="30" rows="10"
                                  placeholder="请输入你的心情">${currentUser.mood}</textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">保存</button>
                </form>
            </div>
        </div>
    </div>
</div>