<%--
  Created by IntelliJ IDEA.
  User: wdd
  Date: 2018/12/28
  Time: 9:02
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
    img{
        border-radius: 50%;
        width: 60px;
    }
    #sub{
        width: 150px;
        height: 30px;
        border-radius: 20px 20px;
        background-color: #9dff82;
        border: 0;
    }
    #sex{
        position: relative;
        right: 33px;
    }
    #car{
        position: relative;
        right: 10px;
    }
    span{
        position: relative;
        right: 10px;
    }
</style>
<body>

<form action="/doCus?action=updateCus" method="post">

    <h1>修改信息</h1>
    <img src="/${sessionScope.cus.cusPhoto}" name="cusImg" ><br><br>
    编号：<input type="text" name="id" value="${sessionScope.cus.id}"/><br><br>
    姓名：<input type="text" name="cusName" value="${sessionScope.cus.cusName}"/><br><br>
    账号：<input type="text" name="cusLogin"  readonly value="${sessionScope.cus.cusLoginName}"/><br><br>
    密码：<input type="text" name="cusPwd" readonly value="${sessionScope.cus.cusPassword}"/><br><br>
    邮箱：<input type="text" name="cusEmail" value="${sessionScope.cus.cusEmail}"/><br><br>
    <label id="sex">性别：</label><span><input type="radio" name="sex" value="男" ${sessionScope.cus.cusSex=='男'?'checked':''}>男
    <input type="radio" name="sex"  value="女" ${sessionScope.cus.cusSex=='女'?'checked':''}>女</span><br><br>
    爱好：<input type="text" name="cusHobby" value="${sessionScope.cus.cusHobby}"/><br><br>
    <label id="car">身份证:</label><input type="text" name="cusCarid" value="${sessionScope.cus.cusCode}"/><br><br>
    生日：<input type="text" name="cusBirthday" value="${sessionScope.cus.cusBirthday}"/><br><br>
    <input type="submit" value="保存资料" id="sub" >
</form>

</body>

</html>
