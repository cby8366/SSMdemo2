function login() {
    $('input[name="radioInput"]:checked').val();
    var userId = $("#userId").val();
    var password = $("#password").val();
    var url="http://localhost:8080/user/login.action";

    var user = {
        userId:userId,
        password:password
    };

    $.ajax({
        url:url,
        contentType:"application/json;charset=utf-8",
        type:"POST",
        data:JSON.stringify(user),
        dataType:"JSON",
        success:function (res) {
            if(res.userId == userId){
                if(res.password == password){
                    window.location.href = "http://localhost:8080/jsp/success.jsp";
                }else {
                    "密码错误"
                }
            }
            else {
                alert("用户名不存在")
            }
        }
    })
}