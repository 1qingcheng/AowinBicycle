<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title></title>
	<link rel="stylesheet" href="/css/reset.css">
	<link rel="stylesheet" href="/css/public.css">
</head>
<body>
<div class="public-header-warrp">
	<div class="public-header">
		<div class="content">
			<div class="public-header-logo"><a href="#"><img src="/images/logo.jpg" style="height: 50px;width: 65px;"><h3 style="padding-bottom: 30px">自行车管理系统</h3></a></div>
			<div class="public-header-admin fr">
				<p class="admin-name">管理员 您好！</p>
				<div class="public-header-fun fr">
					<a href="" class="public-header-loginout">安全退出</a>	
				</div>
			</div>
		</div>
	</div>
</div>
<div class="clearfix"></div>
<!-- 内容展示 -->
<div class="public-ifame mt20">
	<div class="content">
		<div class="clearfix"></div>
		<!-- 左侧导航栏 -->
		<div class="public-ifame-leftnav">
			<div class="public-title-warrp">
				<div class="public-ifame-title ">
					<a href="">首页</a>
				</div>
			</div>
			<ul class="left-nav-list">
				<li class="public-ifame-item">
					<a href="javascript:;">系统管理</a>
					<div class="ifame-item-sub">
						<ul>
							<li><a href="/getAllVender.do" target="content">供应商管理</a></li>
						</ul>
					</div>
				</li>
				<li class="public-ifame-item">
					<a href="javascript:;">租车与还车</a>
					<div class="ifame-item-sub">
						<ul>
							<li><a href="/getAllStation.do?message=rent" target="content">租车</a></li>
							<li><a href="/getAllStation.do?message=return" target="content">还车</a></li>
						</ul>
					</div>
				</li>
				<li class="public-ifame-item">
					<a href="javascript:;">车点车桩维护</a>
					<div class="ifame-item-sub">
						<ul>
							<li><a href="/车点车桩维护/queryStation.jsp" target="content">车点查询</a></li>
							<li><a href="/车点车桩维护/addStation.jsp" target="content">新增车点</a></li>
						</ul>
					</div>
				</li>
				<li class="public-ifame-item">
					<a href="javascript:;">报表统计</a>
					<div class="ifame-item-sub">
						<ul>
							<li><a href="/车辆费用统计/report.jsp" target="content">车辆费用统计</a></li>
						</ul>
					</div>
				</li>
				
			</ul>
		</div>
		<!-- 右侧内容展示部分 -->
		<div class="public-ifame-content">
		<iframe name="content" src="/main.jsp" fpxrameborder="0" id="mainframe" scrolling="yes" marginheight="0" marginwidth="0" width="100%" style="height: 650px;"></iframe>
		</div>
	</div>
</div>
<script src="js/jquery.min.js"></script>
<script>
$().ready(function(){
	var item = $(".public-ifame-item");

	for(var i=0; i < item.length; i++){
		$(item[i]).on('click',function(){
			$(".ifame-item-sub").hide();
			if($(this.lastElementChild).css('display') == 'block'){
				$(this.lastElementChild).hide()
				$(".ifame-item-sub li").removeClass("active");
			}else{
				$(this.lastElementChild).show();
				$(".ifame-item-sub li").on('click',function(){
					$(".ifame-item-sub li").removeClass("active");
					$(this).addClass("active");
				});
			}
		});
	}
});
</script>
</body>
</html>