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

<form action="/doAnn?action=updateAnn" method="post">

    <h1>修改公告信息</h1>
    公告编号：<input type="text" name="id" value="${sessionScope.Ann.id}"/><br><br>
    公告标题：<input type="text" name="anTitle" value="${sessionScope.Ann.anTitle}"/><br><br>
    公告内容：<input type="text" name="anText"   value="${sessionScope.Ann.anText}"/><br><br>
    公告日期：<input type="text" name="anDate" value="${sessionScope.Ann.anDate}"/><br><br>
    <input type="submit" value="保存资料" id="sub" >
</form>

</body>

</html>
