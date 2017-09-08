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
						<th style="width:5%" >车辆编号</th>
						<th style="width:5%">车桩编号</th>
						<th style="width:5%">所属车点</th>
						<th style="width:20%">备注</th>
					</tr>
					<c:forEach items="${requestScope.page.data}" var="pile">
						<tr>
							<td style="text-decoration-line: underline"><span style="cursor: hand" onclick="rentCardIdInput(this)" id="bicycleID" >${pile.bicycle_id}</span><input type="hidden" value="${pile.pile_id}"></td>
							<td><span>${pile.pile_code}</span></td>
							<td><span>${param.station_name}</span></td>
							<td>${pile.remark}</td>
						</tr>
					</c:forEach>

				</table>



				<div class="page">
					当前第${page.currentPage}页
					<c:choose>
						<c:when test="${page.currentPage==1 }">
							<a href="/getPileByStation.do?station_id=${param.station_id}&station_name=${param.station_name}&currentPage=${page.currentPage+1}&condition=1">下一页</a>
							<a href="/getPileByStation.do?station_id=${param.station_id}&station_name=${param.station_name}&currentPage=${page.totalPage}&condition=1">末页</a>
							<form id="currentPageForm">
								<input type="text" class="page-input">
								<input type="button" class="page-btn" value="跳转" onclick="goToRentStation(this)">
							</form>
						</c:when>
						<c:when test="${page.currentPage==page.totalPage }">
							<a href="/getPileByStation.do?station_id=${param.station_id}&station_name=${param.station_name}&currentPage=1&condition=1">首页</a>
							<a href="/getPileByStation.do?station_id=${param.station_id}&station_name=${param.station_name}&currentPage=${page.currentPage-1}&condition=1">上一页</a>
							<form id="currentPageForm">
								<input type="text" class="page-input">
								<input type="button" class="page-btn" value="跳转" onclick="goToRentStation(this)">
							</form>
						</c:when>
						<c:otherwise>
							<a href="/getPileByStation.do?station_id=${param.station_id}&station_name=${param.station_name}&currentPage=1&condition=1">首页</a>
							<a href="/getPileByStation.do?station_id=${param.station_id}&station_name=${param.station_name}&currentPage=${page.currentPage-1}&condition=1">上一页</a>
							<a href="/getPileByStation.do?station_id=${param.station_id}&station_name=${param.station_name}&currentPage=${page.currentPage+1}&condition=1">下一页</a>
							<a href="/getPileByStation.do?station_id=${param.station_id}&station_name=${param.station_name}&currentPage=${page.totalPage}&condition=1">末页</a>

						</c:otherwise>
					</c:choose>
				</div>


			</div>
		</div>
	</div>
</body>
</html>