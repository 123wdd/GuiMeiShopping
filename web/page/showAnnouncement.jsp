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
<h1>公告信息</h1>

<c:choose>
    <c:when test="${not empty sessionScope.Page.pageData}">

        <table border="1px" width="100%">
            <tr>
                <td>公告id</td>
                <td>公告标题</td>
                <td>公告内容</td>
                <td>公告日期</td>
                <td>功能</td>
            </tr>
            <c:forEach items="${sessionScope.Page.pageData}" var="ann">
                <tr>
                    <td>${ann.id}</td>
                    <td>${ann.anTitle}</td>
                    <td>${ann.anText}</td>
                    <td>${ann.anDate}</td>
                    <td><a href="doAnn?action=delAnn&id=${ann.id}">删除</a>
                        <a href="doAnn?action=upAnn&id=${ann.id}">修改</a></td>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="6">
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
