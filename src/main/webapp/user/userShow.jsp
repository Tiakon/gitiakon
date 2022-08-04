<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/publicVariables.jsp" %>
<% System.out.println("**************userShow.jsp"); %>
<div class="data-list">
    <div class="data-list-title">
        <%--<img src="/picture/mainTemp/user_edit_icon.png"/>--%>
        <sapn class="glyphicon glyphicon-edit"></sapn>
        用户信息
    </div>
    <div class="container-fluid container-fluid-mod-3">
        <div class="row">
            <div class="col-xs-12 col-md-4">
                <img src="${currentUser.imageName}" style="width: 100%;" class="img-circle"
                     alt="${currentUser.userName}的头像">
            </div>
            <div class="col-xs-12 col-md-8">
                <form action="UserServlet?action=save" enctype="multipart/form-data" role="form" method="post"
                      onsubmit="javascript:return VerifyFormUpdate()">
                    <div class="form-group">
                        <label for="exampleInputFile">选择头像</label>
                        <input type="file" id="exampleInputFile" name="uploadFileInput">
                        <p class="help-block">这里可添加帮助文本</p>
                    </div>
                    <div class="form-group">
                        <label for="nickNameInput">昵称</label>
                        <input id="nickNameInput" type="text" class="form-control" value="${currentUser.nickName}"
                               placeholder="请输入你的昵称" name="nickNameInput">
                    </div>
                    <div class="form-group">
                        <label for="moodTextArea">心情</label>
                        <textarea name="moodTextArea" class="form-control" id="moodTextArea"
                                  cols="30" rows="10"
                                  placeholder="请输入你的心情">${currentUser.mood}</textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">保存</button>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function VerifyFormUpdate() {
        const nickNameInput = document.getElementById('nickNameInput');
        const moodTextArea = document.getElementById('moodTextArea');
        const nickNameInputTrim = trim(nickNameInput.value);
        const moodTextAreaTrim = trim(moodTextArea.value);

        if (nickNameInputTrim.length === 0 || moodTextAreaTrim === 0) {
            const userError = document.getElementById('userError');
            userError.style.display = "block";
            setTimeout(`userError.style.display = 'none';`, 3000);
            return false;
        }
        return true;
    }
</script>