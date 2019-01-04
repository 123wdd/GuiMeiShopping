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

<form action="/doGoods?action=updateGoods" method="post">

    <h1>修改商品信息</h1>
    <img src="/${sessionScope.good.goodsImage}" name="goodsImg" ><br><br>
    编号：<input type="text" name="id" value="${sessionScope.good.id}"/><br><br>
    商品名称：<input type="text" name="goodsName" value="${sessionScope.good.goodsName}"/><br><br>
    小分类：<input type="text" name="goodsSmalId"  readonly value="${sessionScope.good.goodsSmalId}"/><br><br>
    价格：<input type="text" name="goodsMoney" readonly value="${sessionScope.good.goodsMoney}"/><br><br>
    数量：<input type="text" name="goodsNumber" value="${sessionScope.good.goodsNumber}"/><br><br>
    运费：<input type="text" name="goodsCarriage" value="${sessionScope.good.goodsCarriage}"/><br><br>
    商品类型：<input type="text" name="goodsType" value="${sessionScope.good.goodsType}"/><br><br>
    大分类：<input type="text" name="goodsType" value="${sessionScope.good.goodsType}"/><br><br>
    商家：<input type="text" name="goodsSell" value="${sessionScope.good.goodsSellId}"/><br><br>
    折扣：<input type="text" name="goodsDiscId" value="${sessionScope.good.goodsDiscId}"/><br><br>
    <input type="submit" value="保存资料" id="sub" >
</form>

</body>

</html>
