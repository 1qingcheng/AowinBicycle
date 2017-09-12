<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>车点车桩维护</title>
	<link rel="stylesheet" href="/css/reset.css" />
	<link rel="stylesheet" href="/css/content.css" />
	<script src="/js/jquery.min.js"></script>
	<script src="/js/bicycleRent.js"></script>
</head>
<body marginwidth="0" marginheight="0">
	<div class="container">
		<div class="public-nav">您当前的位置：<a href="">车点车桩维护</a></div>
		<div class="public-content">
			<div class="public-content-header">
				<h3>请选择车点</h3>
			</div>
			<div class="public-content-cont">
				<table class="public-cont-table">
					<tr>
						<th style="width:5%">车点编号</th>
						<th style="width:5%">车点名称</th>
						<th style="width:20%">地址</th>
						<th style="width:20%">备注</th>
					</tr>
					<c:forEach items="${requestScope.page.data}" var="station">
						<tr>

							<td>${station.station_code}</td>
							<td><a href="/getPileByStation.do?station_id=${station.station_id}&station_name=${station.station_name}&condition=1" style="text-decoration-line: underline">${station.station_name}</a></td>
							<td>${station.address}</td>
							<td>${station.remark}</td>
						</tr>
					</c:forEach>
				</table>

				<div class="page">
					当前第${page.currentPage}页
					<c:choose>
						<c:when test="${page.currentPage==1 }">
							<a href="/getAllStation.do?currentPage=${page.currentPage+1}&message=rent">下一页</a>
							<a href="/getAllStation.do?currentPage=${page.totalPage}&message=rent">末页</a>
							<form id="currentPageForm" style="margin-bottom: 50px">
								<input type="text" class="page-input">
								<input type="button" class="page-btn" value="跳转" onclick="goToRentStation(this)">
							</form>
						</c:when>
						<c:when test="${page.currentPage==page.totalPage }">
							<a href="/getAllStation.do?currentPage=1&message=rent">首页</a>
							<a href="/getAllStation.do?currentPage=${page.currentPage-1}&message=rent">上一页</a>
							<form id="currentPageForm" style="margin-bottom: 50px">
								<input type="text" class="page-input">
								<input type="button" class="page-btn" value="跳转" onclick="goToRentStation(this)">
							</form>
						</c:when>
						<c:otherwise>
							<a href="/getAllStation.do?currentPage=1&message=rent">首页</a>
							<a href="/getAllStation.do?currentPage=${page.currentPage-1}&message=rent">上一页</a>
							<a href="/getAllStation.do?currentPage=${page.currentPage+1}&message=rent">下一页</a>
							<a href="/getAllStation.do?currentPage=${page.totalPage}&message=rent">末页</a>
							<form id="currentPageForm" style="margin-bottom: 50px">
								<input type="text" class="page-input">
								<input type="button" class="page-btn" value="跳转" onclick="goToRentStation(this)">
							</form>
						</c:otherwise>
					</c:choose>
				</div>


			</div>
		</div>
	</div>
</body>
</html>