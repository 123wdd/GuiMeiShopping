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
<h2>🕴添加大分类🕴</h2>
<form action="/doBig?action=addBig" method="post">
    分类编号：<input type="text" name="id" /><br><br>
    分类名称：<input type="text" name="name" /><br><br>
    分类描述：<input type="text" name="text" /><br><br>
    <input type="submit" value="添加" id="sub">
</form>

</body>
</html>
