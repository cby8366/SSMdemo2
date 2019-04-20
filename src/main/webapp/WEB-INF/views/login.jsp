<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<%--<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>

<script type="text/javascript">

    function userLogin(){
        $.ajax({
            type : "post",
            url : "checkLogin",
            dataType:"json",
            data:{
                userId:$("#userId").val(),
                password:$("#password").val()
            },
            success : function(data) {
                if(data.code == "0"){
                    alert("成功");
                    $("#showMessage").val(data.tureInfo+"");
                    // window.location.href = "views/index.jsp";
                }else {
                    alert(data.errorInfo+"");
                    $("#showMessage").val(data.errorInfo+"");
                }
            }
        });
    }
</script>--%>
<%--
<body>
<form action="/checkLogin" method="post">
用户名：<input type="text" name="userId" id="userId"/><br/>
密  码：<input type="password" name="password" id="password"/><br/>
    <label><input type="radio" name="type" value="1" checked/>业主</label>
    <label><input type="radio" name="type" value="2"/>管理员</label><br/>
<input type="submit" name="login" value="登录"/><br/>
</form>
--%>
<script type="text/javascript" language="JavaScript">
    $(document).ready(function () {
        $('#login').click(function () {
            $.ajax({
                type: "post",
                url: "checkLogin",
                data: {
                    "userId": $("#userId").val(),
                    "password": $("#pwd").val(),
                },
                dataType: "JSON",
                async: false,
                beforeSend: function () {
                    alert("正在提交");
                },
                success: function (data) {
                    if (data == 1) {
                        alert("登录成功")
                        window.location.href = "userList";

                    } else {
                        alert("用户名或者密码错误!");
                    }
                },
                error: function () {
                    alert("提交失败");
                }
            });
        })
    })
</script>

<h1>登录页面</h1>
<form class="bs-example bs-example-form" role="form1" method="post">
    <div class="input-group">
        <span class="input-group-addon">userId</span>
        <input type="text" id="userId" class="form-control" >
    </div>
    <div class="input-group">
        <span class="input-group-addon">password</span>
        <input type="text" id="pwd" class="form-control" >
    </div>
</form>
<button  class="btn btn-info" style="align-content: center" id="login">登录</button>
</div>

</body>
</html>