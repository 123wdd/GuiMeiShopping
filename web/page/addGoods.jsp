<%--
  Created by IntelliJ IDEA.
  User: lx
  Date: 2018/12/31
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <script type="text/javascript" src="/static/js/jquery-1.8.2.min.js"></script>
    <style>
        body{
            text-align: center;
        }

    </style>
</head>
<body>
<h1>添加商品</h1>

    <form action="doGoods?action=addGoods" method="post">

        商品id: <input type="text" name="id"/><br><br>
        商品名:<input type="text" name="goodsName"/><br><br>
        小分类id:<input type="text" name="goodsSmalId"/><br><br>
       价格:<input type="text" name="goodsMoney" /><br><br>
       库存:<input type="text" name="goodsNumber"/><br><br>
        商品图片:<input type="file" name="goodsImage"/><br><br>
        运费:<input type="text" name="goodsCarriage"/><br><br>
        商品种类:<input type="text" name="goodsType"/><br><br>
        商家id:<input type="text" name="goodsSeId"/>
     <br><br>
        折扣:<input type="text" name="goodsDiscId"/><br><br>
        <input class="layui-btn layui-btn-lg" type="submit"  value="添加"/>
    </form>
<%--<script>--%>
    <%--$(function () {--%>
        <%--var url = "doGoods";--%>
        <%--var parameterData = {action:"showSmallclass"}--%>
        <%--$.getJSON(url,parameterData,function (scList) {--%>
            <%--$.each(scList,function(index,sc){--%>
                <%--$("select[name='goodsSmalId']").append("<option value='"+sc.id+"'>"+sc.id+sc.smallName+"</option>")--%>
            <%--})--%>
        <%--})--%>
    <%--});--%>
<%--</script>--%>
<%--<script>--%>
    <%--$(function () {--%>
        <%--var url = "doGoods";--%>
        <%--var parameterData = {action:"showSeller"}--%>
        <%--$.getJSON(url,parameterData,function (seList) {--%>
            <%--$.each(seList,function(index,se){--%>
                <%--$("select[name='goodsSeId']").append("<option value='"+se.id+"'>"+se.id+se.sellerName+"</option>")--%>
            <%--})--%>
        <%--})--%>
    <%--});--%>
<%--</script>--%>
</body>
</html>
