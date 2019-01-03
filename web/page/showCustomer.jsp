<%--
  Created by IntelliJ IDEA.
  User: wdd
  Date: 2018/12/19
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="<%=request.getContextPath()%>/"/>
    <title>Title</title>
</head>
<style>
    body{
        text-align: center;
    }
    tr td{
        text-align: center;
    }
    table{

    }
    #ss{
        border-radius: 20px 20px;
        background-color: #009E94;
        border: 0px;
        width: 100px;
        height: 25px;
        position: relative;
        left: 40px;
    }
    a{
        text-decoration: none;
    }
</style>
<body>
<h1>顾客信息</h1>
<form action="doSup?action=jlQuery&pageNumber=1" method="post">
    编号：<input type="text" name="cusId" placeholder="请输入编号"/>
    账号：<input type="text" name="cusLogin" placeholder="请输入账号"/>
    性别：<select name="cusSex">
    <option value="">请选择</option>
    <option value="男">男</option>
    <option value="女">女</option>
</select>
    <input type="submit" id="ss" value="搜索"/>
</form>
<c:choose>
    <c:when test="${not empty sessionScope.Page.pageData}">

        <table border="1px" width="100%">
            <tr>
                <td>编号</td>
                <td>姓名</td>
                <td>账号</td>
                <td>密码</td>
                <td>邮箱</td>
                <td>性别</td>
                <td>头像</td>
                <td>爱好</td>
                <td>身份证号</td>
                <td>生日</td>
                <td>功能</td>
            </tr>
            <c:forEach items="${sessionScope.Page.pageData}" var="cus">
                <tr>
                    <td>${cus.id}</td>
                    <td>${cus.cusName}</td>
                    <td>${cus.cusLoginName}</td>
                    <td>${cus.cusPassword}</td>
                    <td>${cus.cusEmail}</td>
                    <td>${cus.cusSex}</td>
                    <td><img src="${cus.cusPhoto}" width="40px"></td>
                    <td>${cus.cusHobby}</td>
                    <td>${cus.cusCode}</td>
                    <td>${cus.cusBirthday}</td>
                    <td><a href="doCus?action=delCus&id=${cus.id}">删除</a>
                        <a href="doCus?action=upCus&id=${cus.id}">修改</a></td>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="12">
                    <%@include file="PageUtil.jsp"%>
                </td>
            </tr>
        </table>
    </c:when>
</c:choose>
<%
    if("tr".equals(session.getAttribute("true"))){%><script>alert("删除成功")</script><% }


    if("fa".equals(session.getAttribute("false"))){ %><script>alert("删除失败")</script><%}


%>


</body>
</html>
