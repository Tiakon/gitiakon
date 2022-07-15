/**
 * Created by Hoictas on 2017/11/15.
 * @return {boolean}
 */

function VerifyLogin() {

    var inputUserName = document.getElementById("inputUserName");
    var inputPassword = document.getElementById("inputPassword");
    var error = document.getElementById("error");
    var form_group = document.getElementsByClassName("form-group");

    var username = trim(inputUserName.value);
    var password = trim(inputPassword.value);

    if (username.length === 0) {
        form_group[0].className = "form-group has-error";
        var username_label = form_group[0].firstElementChild;
        username_label.className = "control-label";
        username_label.innerHTML = "用户名不能为空";
        return false;
    } else {
        form_group[0].className = "form-group";
        var username_label = form_group[0].firstElementChild;
        username_label.className = "sr-only";
        username_label.innerHTML = "用户名";
    }
    if (password.length == 0) {
        form_group[1].className = "form-group has-error";
        var username_label = form_group[1].firstElementChild;
        username_label.className = "control-label";
        username_label.innerHTML = "密码不能为空";
        return false;
    } else {
        form_group[1].className = "form-group";
        var username_label = form_group[1].firstElementChild;
        username_label.className = "sr-only";
        username_label.innerHTML = "密码";
    }
    error.style.display = "none";
    return true;
}