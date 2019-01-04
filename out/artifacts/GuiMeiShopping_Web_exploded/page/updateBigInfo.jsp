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

    #sub{
        width: 150px;
        height: 30px;
        border-radius: 20px 20px;
        background-color: #9dff82;
        border: 0;
    }
    input{
        width: 200px;
        height: 30px;
    }


    span{
        position: relative;
        right: 10px;
    }
</style>
<body>

<form action="/doBig?action=updateBig" method="post">

    <h1>修改大分类信息</h1>

    分类编号：<input type="text" name="id" value="${sessionScope.xgBig.id}"/><br><br>
    分类名称：<input type="text" name="bigName" value="${sessionScope.xgBig.bigName}"/><br><br>
    分类描述：<input type="text" name="bigText"  readonly value="${sessionScope.xgBig.bigText}"/><br><br>
    <input type="submit" value="保存资料" id="sub" >
</form>

</body>
</html>
