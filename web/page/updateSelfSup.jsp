<%--
  Created by IntelliJ IDEA.
  User: wdd
  Date: 2018/12/27
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    form{
        text-align: center;
    }
    input{
        width: 200px;
        height: 30px;
    }
    #sub{
        border-radius: 20px 20px;
        border: 0px;
        background-color: #ff717f;
    }
    img{
        width: 70px;
        border-radius: 50%;
    }
</style>
<body >
<form action="/doSup?action=UpdateSelf" method="post">
    <h2>💗💗💗💗💗💗个人资料信息💗💗💗💗💗💗</h2>
    <img src="/${sessionScope.loginSup.userImage}" alt="" name="userImage"  ><br><br>
    编号：<input type="text" name="id" readonly value="${sessionScope.loginSup.id}"/><br><br>
    id：<input type="text" name="userId" value="${sessionScope.loginSup.userId}"/><br><br>
    姓名：<input type="text" name="userName" value="${sessionScope.loginSup.userName}"/><br><br>
    登录名：<input type="text" name="userLoginName" value="${sessionScope.loginSup.userLoginName}"/><br><br>
    状态：<input type="text" name="userStatus" value="${sessionScope.loginSup.userStatus}"/><br><br>
    密码：<input type="text" name="userPwd" readonly value="${sessionScope.loginSup.userPassword}"/><br><br>

    <input type="submit" value="保存资料" id="sub">

</form>



</body>
</html>
