<%--
  Created by IntelliJ IDEA.
  User: wdd
  Date: 2018/12/27
  Time: 18:14
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
        border-radius: 20px 20px;
        border: 0px;
        background-color: #ff717f;
    }
    img{
        width: 70px;
        border-radius: 50%;
    }
</style>
<body >
<form action="/doSell?action=updateSell" method="post">
    <h2>💗💗💗💗💗💗商家资料信息💗💗💗💗💗💗</h2>
    编号：<input type="text" name="id"  value="${sessionScope.Seller.id}"/><br><br>
    商家名称：<input type="text" name="sellName" value="${sessionScope.Seller.sellerName}"/><br><br>
    商家姓名：<input type="text" name="sellUser" value="${sessionScope.Seller.sellerUser}"/><br><br>
    商家密码：<input type="password" name="sellPwd"  readonly value="${sessionScope.Seller.sellerPassword}"/><br><br>
    商家性别：<input type="radio" name="sex" value="男"${sessionScope.Seller.sellerSex=='男'?'checked':''}/>男
   <input type="radio" name="sex" value="女"${sessionScope.Seller.sellerSex=='女'?'checked':''}/>女<br><br>
    商家生日：<input type="text" name="sellBir" value="${sessionScope.Seller.sellerBirthday}"/><br><br>
    商家身份证号：<input type="text" name="sellIdCard" readonly value="${sessionScope.Seller.sellerIdCard}"/><br><br>
    商家电话：<input type="text" name="sellPhone" readonly value="${sessionScope.Seller.sellerTel}"/><br><br>
    商家地址：<input type="text" name="sellAddress" readonly value="${sessionScope.Seller.sellerAddress}"/><br><br>
    商家邮箱：<input type="text" name="sellEmail" readonly value="${sessionScope.Seller.sellerEmail}"/><br><br>
    <input type="submit" value="保存资料" id="sub">

</form>



</body>
</html>
