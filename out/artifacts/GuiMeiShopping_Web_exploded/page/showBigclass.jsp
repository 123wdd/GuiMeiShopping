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
       position: relative;
        left: 25%;
    }

    a{
        text-decoration: none;
    }
    #add{
        background-color: #1E9FFF;
        width: 200px;
        height: 30px;

    }


</style>
<body>
<h1>大分类信息</h1>
<a href="page/addBigClass.jsp" id="add">添加大分类</a><br><br>
<form action="doBig?action=queryJlBig&pageNumber=1" method="post">
    商品名称：<input type="text" name="goodName" placeholder="请输入商品"/>
    小分类：<input type="text" name="smallByType" placeholder="请输入小分类"/>
    商家：<input type="text" name="sell" placeholder="请输入商家"/>
</form>
<c:choose>
    <c:when test="${not empty sessionScope.Page.pageData}">

        <table border="1px" width="50%">
            <tr>
                <td>编号</td>
                <td>分类名称</td>
                <td>分类描述</td>
                <td>功能</td>
            </tr>
            <c:forEach items="${sessionScope.Page.pageData}" var="big">
                <tr>
                    <td>${big.id}</td>
                    <td>${big.bigName}</td>
                    <td>${big.bigText}</td>
                    <td><a href="doBig?action=delBig&id=${big.id}">删除</a>
                        <a href="doBig?action=bb&id=${big.id}">修改</a></td>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5">
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
