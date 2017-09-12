<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>车点车桩管理</title>
	<link rel="stylesheet" href="/css/reset.css" />
	<link rel="stylesheet" href="/css/public.css" />
	<link rel="stylesheet" href="/css/content.css" />
	<script src="/js/jquery.min.js"></script>
	<script src="/js/bicycleRent.js"></script>

</head>
<body marginwidth="0" marginheight="0">
	<div class="container">
		<div class="public-nav">您当前的位置：<a href="">车点添加</a></div>
		<div class="public-content">

			<div class="public-content-cont">
			<form id="addStation">
				<div>
					<table class="public-cont-table">
						<tr>
							<th style="width:5%">车点编号</th>
							<th style="width:5%">车点名称</th>
							<th style="width:5%">车点经度</th>
							<th style="width:5%">车点纬度</th>
							<th style="width:20%">地址</th>
							<th style="width:20%">负责人</th>
							<th style="width:20%">修建时间</th>
							<th style="width:20%">运行时间</th>
							<th style="width:20%">备注</th>
						</tr>
						<tr>
							<td><input type="text" name="station_code" placeholder="1-10位的数字或字母" /></td>
							<td><input type="text" name="station_name" placeholder="1-25个字符" /></td>
							<td><input type="text" name="longitude"/></td>
							<td><input type="text" name="latitude"/></td>
							<td><input type="text" name="address"/></td>
							<td><input type="text" name="person_in_charge"/></td>
							<td><input type="text" name="build_time"/></td>
							<td><input type="text" name="run_time"/></td>
							<td><input type="text" name="remark"/></td>
						</tr>
					</table>
				</div>
				<div style="margin-top: 10px;margin-bottom: 25px"><input type="button" value="增加车桩" onclick="addPile()"></div>



				<div style="display: none" id="pileDiv">
					<table class="public-cont-table" id="pileDetail" >
						<tr>
							<th style="width:5%">车桩编号</th>
							<th style="width:5%">车桩供应商编号</th>
							<th style="width:5%">状态</th>
							<th style="width:5%">安装日期</th>
							<th style="width:20%">所存车辆编号</th>
							<th style="width:20%">备注</th>
							<th style="width:20%">删除</th>
						</tr>
					</table>

					<div class="form-group" style="margin-left:150px;">
						<input type="button" onclick="addStation()" class="sub-btn" value="提  交"/>
						<input type="reset" class="sub-btn" value="重  置" />
					</div>
				</div>


				</form>
			</div>
		</div>
	</div>

</body>
</html>