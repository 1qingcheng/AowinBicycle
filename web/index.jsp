<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
			<div class="public-header-logo"><a href=""><i>LOGO</i>
			<h3>aowin</h3></a></div>
			<div class="public-header-admin fr">
				<p class="admin-name">管理员 您好！</p>
				<div class="public-header-fun fr">
					<a href="" class="public-header-man">管理</a>
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
	<!-- 内容模块头 -->
		<div class="public-ifame-header">
			<ul>
				<li class="ifame-item logo">
					<div class="item-warrp">
						<a href="#"><i>LOGO</i>
							<h3 class="logo-title">WorldVentures梦幻之旅</h3>
							<p class="logo-des">创建于 2016/4/22 22:22:47</p>
						</a>
					</div>
				</li>
				<li class="ifame-item"><div class="item-warrp"><span>注册时间：2015/11/21 21:14:01<br>VIP有效期：</span></div></li>
				<li class="ifame-item"><div class="item-warrp" style="border:none"><span>网站浏览量：15451</span></div></li>
				<div class="clearfix"></div>
			</ul>
		</div>
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
							<li class="active"><a href="系统管理/config.html" target="content">网站配置</a></li>
							<li><a href="系统管理/admin_music.html" target="content">背景音乐管理</a></li>
							<li><a href="系统管理/admin_cardTemplate.html" target="content">名片模板管理</a></li>
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
					<a href="javascript:;">旅游套餐</a>
					<div class="ifame-item-sub">
						<ul>
							<li><a href="旅游管理/lytc_manage.html" target="content">信息列表</a>|<a href="#" target="content">添加</a></li>
							<li><a href="#" target="content">分类管理</a></li>
							<li><a href="#" target="content">分类管理</a></li>
							<li><a href="旅游管理/listbanner.html" target="content">列表页轮播管理</a></li>
							<li><a href="旅游管理/listbanner.html" target="content">分类轮播管理</a></li>
							<li><a href="旅游管理/listbanner.html" target="content">旅游预订管理</a></li>
						</ul>
					</div>
				</li>
				<li class="public-ifame-item">
					<a href="javascript:;">帮助管理</a>
					<div class="ifame-item-sub">
						<ul>
							<li><a href="#" target="content">信息列表</a>|<a href="#" target="content">添加</a></li>
						</ul>
					</div>
				</li>
				
			</ul>
		</div>
		<!-- 右侧内容展示部分 -->
		<div class="public-ifame-content">
		<iframe name="content" src="main.html" frameborder="0" id="mainframe" scrolling="yes" marginheight="0" marginwidth="0" width="100%" style="height: 1000px;"></iframe>
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