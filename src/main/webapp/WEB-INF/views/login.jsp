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
<body>
<form action="/checkLogin" method="post">
用户名：<input type="text" name="userId" id="userId"/><br/>
密  码：<input type="password" name="password" id="password"/><br/>
    <label><input type="radio" name="type" value="1" checked/>业主</label>
    <label><input type="radio" name="type" value="2"/>管理员</label><br/>
<input type="submit" name="login" value="登录"/><br/>
</form>

</body>
</html>