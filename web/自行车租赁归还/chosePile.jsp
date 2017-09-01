<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>自行车租赁</title>
	<link rel="stylesheet" href="/css/reset.css" />
	<link rel="stylesheet" href="/css/content.css" />
	<script src="/js/jquery.min.js"></script>
	<script src="/js/bicycleRent.js"></script>


</head>
<body marginwidth="0" marginheight="0">
	<div class="container">
		<div class="public-nav">您当前的位置：<a href="">自行车租赁</a></div>
		<div class="public-content">
			<div class="public-content-header">
				<h3>请选择车辆</h3>
			</div>
			<div class="public-content-cont">
				<table class="public-cont-table">
					<tr>
						<th style="width:5%">车辆编号</th>
						<th style="width:5%">车桩编号</th>
						<th style="width:5%">所属车点</th>
						<th style="width:20%">备注</th>
					</tr>
					<c:forEach items="${requestScope.pileList}" var="p">
						<tr>
							<td style="text-decoration-line: underline"><span onclick="cardidInput()">${p.bicycle_id}</span></td>
							<td>${p.pile_code}</td>
							<td>${param.station_name}</td>
							<td>${p.remark}</td>
						</tr>
					</c:forEach>
				</table>

				<%--<div class="form-group">--%>
					<%--<label>请输入卡号</label>--%>
					<%--<input class="form-input-txt" type="text" name="card_code" />--%>
				<%--</div>--%>
				<%--<div style="display: none">--%>
					<%--<form id="card_code_form">--%>
						<%--<input class="form-input-txt" type="text" name="card_code" />--%>
					<%--</form>--%>
				<%--</div>--%>


				<div class="page">
					<form action="" method="get">
					共<span>42</span>个站点
						<a href="">首页</a>
						<a href="">上一页</a>
						<a href="">下一页</a>
						第<span style="color:red;font-weight:600">12</span>页
						共<span style="color:red;font-weight:600">120</span>页
						<input type="text" class="page-input">
						<input type="submit" class="page-btn" value="跳转">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>