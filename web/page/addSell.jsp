<%--
  Created by IntelliJ IDEA.
  User: wdd
  Date: 2018/12/29
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    body{
        text-align: center;
    }
    #sub{
        width: 140px;
        height: 30px;
        border-radius: 20px 20px;
        border: 0;
        background-color: #f78648;
    }
</style>
<body>
<h2>🕴添加商家🕴</h2>
<form action="/doSell?action=addSell" method="post">
    商家编号：<input type="text" name="id" /><br><br>
    商家名称：<input type="text" name="name" /><br><br>
    商家名字：<input type="text" name="user" /><br><br>
    商家密码：<input type="text" name="pwd" /><br><br>
    商家性别：<input type="radio" name="sex" />男
    <input type="radio" name="sex" />女<br><br>
    商家生日：<input type="text" name="birthday" /><br><br>
    商家身份证号：<input type="text" name="idCard" /><br><br>
    商家电话：<input type="text" name="phone" /><br><br>
    商家地址：<input type="text" name="address" /><br><br>
    商家邮箱：<input type="text" name="email" /><br><br>
    <input type="submit" value="添加" id="sub">
</form>

</body>
</html>
