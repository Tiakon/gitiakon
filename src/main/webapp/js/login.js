function VerifyLogin() {

    let username_label;
    const inputUserName = document.getElementById("inputUserName");
    const inputPassword = document.getElementById("inputPassword");
    const error = document.getElementById("error");
    const form_group = document.getElementsByClassName("form-group");

    const username = trim(inputUserName.value);
    const password = trim(inputPassword.value);

    if (username.length === 0) {
        form_group[0].className = "form-group has-error";
        username_label = form_group[0].firstElementChild;
        username_label.className = "control-label";
        username_label.innerHTML = "用户名不能为空";
        return false;
    } else {
        form_group[0].className = "form-group";
        username_label = form_group[0].firstElementChild;
        username_label.className = "sr-only";
        username_label.innerHTML = "用户名";
    }
    if (password.length === 0) {
        form_group[1].className = "form-group has-error";
        username_label = form_group[1].firstElementChild;
        username_label.className = "control-label";
        username_label.innerHTML = "密码不能为空";
        return false;
    } else {
        form_group[1].className = "form-group";
        username_label = form_group[1].firstElementChild;
        username_label.className = "sr-only";
        username_label.innerHTML = "密码";
    }
    error.style.display = "none";
    return true;
}