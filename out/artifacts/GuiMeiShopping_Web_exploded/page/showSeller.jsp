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

    a{
        text-decoration: none;
    }
</style>
<body>
<h1>商家信息</h1>

<c:choose>
    <c:when test="${not empty sessionScope.Page.pageData}">

        <table border="1px" width="100%">
            <tr>
                <td>商家id</td>
                <td>商家名称</td>
                <td>商家名字</td>
                <%--<td>商家密码</td>--%>
                <td>商家性别</td>
                <td>商家生日</td>
                <td>商家身份证号</td>
                <td>商家电话</td>
                <td>商家地址</td>
                <td>商家邮箱</td>
                <td>功能</td>
            </tr>
            <c:forEach items="${sessionScope.Page.pageData}" var="sell">
                <tr>
                    <td>${sell.id}</td>
                    <td>${sell.sellerName}</td>
                    <td>${sell.sellerUser}</td>
                    <%--<td>${sell.sellerPassword}</td>--%>
                    <td>${sell.sellerSex}</td>
                    <td>${sell.sellerBirthday}</td>
                    <td>${sell.sellerIdCard}</td>
                    <td>${sell.sellerTel}</td>
                    <td>${sell.sellerAddress}</td>
                    <td>${sell.sellerEmail}</td>
                    <td><a href="doSell?action=delSeller&id=${sell.id}">删除</a>
                        <a href="doSell?action=upSeller&id=${sell.id}">修改</a></td>
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
<%--<%--%>
    <%--if("tr".equals(session.getAttribute("true"))){%><script>alert("删除成功")</script><% }--%>


    <%--if("fa".equals(session.getAttribute("false"))){ %><script>alert("删除失败")</script><%}--%>


<%--%>--%>


</body>
</html>
