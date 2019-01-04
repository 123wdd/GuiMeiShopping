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
<h1>小分类信息</h1>
<form action="doSmall?action=jlQuery&pageNumber=1" method="post">
    大分类编号：<select name="bigId">
    <option value="">请选择</option>
    <option value="">请选择</option>
</select>
    小分类名称：<input type="text" name="smallName" placeholder="请输入小分类名称"/>
    <input type="submit" id="ss" value="搜索"/>
</form>
<c:choose>
    <c:when test="${not empty sessionScope.Page.pageData}">

        <table border="1px" width="100%">
            <tr>
                <td>编号</td>
                <td>小分类名称</td>
                <td>大分类id</td>
                <td>描述</td>
                <td>大分类名称</td>
                <td>功能</td>
            </tr>
            <c:forEach items="${sessionScope.Page.pageData}" var="sma">
                <tr>
                    <td>${sma.sma.id}</td>
                    <td>${sma.sma.smallName}</td>
                    <td>${sma.sma.smallBigId}</td>
                    <td>${sma.sma.smallText}</td>
                    <td>${sma.big.bigName}</td>
                    <td><a href="doSmall?action=delSmall&id=${sma.sma.id}">删除</a>
                        <a href="doSmall?action=upCus&id=${cus.id}">修改</a></td>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="7">
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
