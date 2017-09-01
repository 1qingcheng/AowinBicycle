<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JerryCheng
  Date: 2017.9.1
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增订单</title>
    <script src="/js/jquery-1.8.1.min.js"></script>
    <script src="http://malsup.github.io/jquery.form.js"></script>
    <script>
        $(function () {
            $('#venderId').click(function () {
                $.ajax({
                     url:'//queryvender.do',
                    type:'post',
                    dataType:'json',
                    success:function(data){
                        $("#makemodule").append(result);
                    },
                error;function(){
                    alert("无供应商");
                }
                });
            })
        })
        function add() {
            $('#orderform').ajaxSubmit(function (message) {
                alert(message);
            });
            return false;
        }


    </script>
</head>
<body>
增加订单
<form id="orderform" action="/addbicycleorder.do" method="post">
    <input name="bicycleOrder.orderId" placeholder="单据编号" >
    <%--<input name="bicycleOrder.venderId" placeholder="供应商编号" >--%>
    <select name="bicycleOrder.venderId" id="venderId" onclick="queryvender()">
        <c:forEach items="${requestScope.venders}" var="vender" >
            <<option value="${vender.venderId}">${vender.venderId}</option>
        </c:forEach>
    </select>
    <input name="bicycleOrder.buyDate" placeholder="购买日期" >
    <input name="bicycleOrder.buyNum" placeholder="购买数量" >
    <input name="bicycleOrder.buyPrice" placeholder="总金额" >
    <input name="bicycleOrder.personInCharge" placeholder="购入负责人" >
    <input name="bicycleOrder.invoiceNo" placeholder="发票号码" >
    <input name="bicycleOrder.userId" placeholder="创建人编号" >
    <input name="bicycleOrder.operatorTime" placeholder="创建日期" >
    <input name="bicycleOrder.remark" placeholder="备注" >
    <input name="bicycleOrder.status" placeholder="订单状态" >
    <input type="button" onclick="add()" value="增加">
</form>
</body>
</html>
