<%--
  Created by IntelliJ IDEA.
  User: wdd
  Date: 2019/1/2
  Time: 11:39
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
<h2>🕴添加公告🕴</h2>
<form action="/doAnn?action=addAnn" method="post">
    公告编号：<input type="text" name="id" /><br><br>
    公告标题：<input type="text" name="title" /><br><br>
    公告内容：<input type="text" name="text" /><br><br>
    公告日期：<input type="text" name="date" /><br><br>
    <input type="submit" value="添加" id="sub">
</form>



</body>
</html>
