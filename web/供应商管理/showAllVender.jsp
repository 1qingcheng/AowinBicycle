<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>供应商管理</title>
	<link rel="stylesheet" href="/css/reset.css" />
	<link rel="stylesheet" href="/css/content.css" />
	<script src="/js/jquery.min.js"></script>
	<script src="/js/bicycleRent.js"></script>
</head>
<body marginwidth="0" marginheight="0">
	<div class="container">
		<div class="public-nav">您当前的位置：<a href="">供应商管理</a></div>
		<div class="public-content">
			<div class="public-content-header">
				<a href="/供应商管理/addVender.jsp">新增供应商</a>
			</div>

			<div class="public-content-cont">
				<table class="public-cont-table">
					<tr>
						<th style="width:5%">供应商编号</th>
						<th style="width:5%">供应商类型</th>
						<th style="width:20%">名称</th>
						<th style="width:20%">地址</th>
						<th style="width:20%">联系电话</th>
						<th style="width:20%">联系人</th>
						<th style="width:20%">操作</th>

					</tr>
					<c:forEach items="${requestScope.venderList}" var="v">
						<tr>
							<input type="hidden" value="${v.vender_id}">
							<td>${v.vender_code}</td>
							<td>${v.vender_type}</td>
							<td>${v.vender_name}</td>
							<td>${v.address}</td>
							<td>${v.telphone}</td>
							<td>${v.contacts}</td>
							<td><input type="button" value="修改" onclick="goChange(this)"><input type="button" value="注销" onclick="goLogOut(this)"></td>
						</tr>

					</c:forEach>
				</table>

			</div>
		</div>
	</div>
</body>
</html>