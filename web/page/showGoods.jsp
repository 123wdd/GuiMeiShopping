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
<h1>商品信息</h1>

<c:choose>
    <c:when test="${not empty sessionScope.Page.pageData}">

        <table border="1px" width="100%">
            <tr>
                <td>编号</td>
                <td>商品名称</td>
                <td>小分类名称</td>
                <td>价格</td>
                <td>数量</td>
                <td>样式</td>
                <td>运费</td>
                <td>商品类型</td>
                <td>商家名称</td>
                <td>折扣</td>
                <td>功能</td>
            </tr>
            <c:forEach items="${sessionScope.Page.pageData}" var="gg">
                <tr>
                    <td>${gg.good.id}</td>
                    <td>${gg.good.goodsName}</td>
                    <td>${gg.sma.smallName}</td>
                    <td>${gg.good.goodsMoney}</td>
                    <td>${gg.good.goodsNumber}</td>
                    <td><img src="${gg.good.goodsImage}" width="40px"></td>
                    <td>${gg.good.goodsCarriage}</td>
                    <td>${gg.good.goodsType}</td>
                    <td>${gg.sel.sellerName}</td>
                    <td>${gg.dis.discRate}</td>
                    <td><a href="doGoods?action=delGoods&id=${gg.good.id}">删除</a>
                        <a href="doGoods?action=upGoods&id=${gg.good.id}">修改</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="11">
                    <%@include file="PageUtil.jsp"%>
                </td>
            </tr>
        </table>
    </c:when>
</c:choose>
<%
    if("tr".equals(request.getAttribute("true"))){%><script>alert("删除成功")</script><% }


    if("fa".equals(request.getAttribute("false"))){ %><script>alert("删除失败")</script><%}


%>


</body>
</html>
