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
<h1>订单信息</h1>

<c:choose>
    <c:when test="${not empty sessionScope.Page.pageData}">

        <table border="1px" width="100%">
            <tr>
                <td>订单id</td>
                <td>商品id</td>
                <td>顾客id</td>
                <td>订单日期</td>
                <td>收货地址</td>
                <td>订单金额</td>
                <td>订单状态</td>
                <td>功能</td>
            </tr>
            <c:forEach items="${sessionScope.Page.pageData}" var="oo">
                <tr>
                    <td>${oo.id}</td>
                    <td>${oo.orderseGoodsId}</td>
                    <td>${oo.orderseCusId}</td>
                    <td>${oo.orderseDate}</td>
                    <td>${oo.orderseAddress}</td>
                    <td>${oo.orderseMoney}</td>
                    <td>${oo.orderseStatus}</td>
                    <td><a href="doOrder?action=delOrder&id=${oo.id}">删除</a>
                        <a href="doOrder?action=upOrder&id=${cus.id}">修改</a></td>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="9">
                    <%@include file="PageUtil.jsp"%>
                </td>
            </tr>
        </table>
    </c:when>
</c:choose>
<%
    if("yes".equals(session.getAttribute("true"))){%><script>alert("删除成功")</script><% }


    if("no".equals(session.getAttribute("false"))){ %><script>alert("删除失败")</script><%}


%>


</body>
</html>
