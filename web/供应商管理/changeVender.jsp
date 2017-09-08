<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>供应商管理</title>
	<link rel="stylesheet" href="/css/reset.css" />
	<link rel="stylesheet" href="/css/public.css" />
	<link rel="stylesheet" href="/css/content.css" />
	<script src="/js/jquery.min.js"></script>
	<script src="/js/bicycleRent.js"></script>

</head>
<body marginwidth="0" marginheight="0">
	<div class="container">
		<div class="public-nav">您当前的位置：<a href="">供应商修改</a></div>
		<div class="public-content">

			<div class="public-content-cont">
			<form action="/updateVender.do" method="post">
				<input type="hidden" value="${param.vender_id}" name="vender_id">
				<div class="form-group"><label for="">供应商编号</label><input class="form-input-txt" type="text" name="vender_code" placeholder="1-10位的数字或字母" onchange="venderCodeReg()" value="${requestScope.Vender.vender_code}"/>
                </div>
				<div class="form-group">
					<label for="">供应商类型</label>
					<input class="form-input-txt" type="text" name="vender_type" placeholder="1为生产商，2为供应商"  onchange="venderTypeReg()" value="${requestScope.Vender.vender_type}"/>
				</div>
                <div class="form-group">
					<label for="">名称</label>
					<input class="form-input-txt" type="text" name="vender_name" value="${requestScope.Vender.vender_name}" />
				</div>
				<div class="form-group">
					<label for="">地址</label>
					<input class="form-input-txt" type="text" name="address" value="${requestScope.Vender.address}" />
				</div>
				<div class="form-group">
					<label for="">联系电话</label>
					<input class="form-input-txt" type="text" name="telphone" value="${requestScope.Vender.telphone}" />
				</div>
				<div class="form-group">
					<label for="">联系人</label>
					<input class="form-input-txt" type="text" name="contacts" value="${requestScope.Vender.contacts}" />
				</div>
				<div class="form-group">
					<label for="">生产许可证</label>
					<input class="form-input-txt" type="text" name="product_license" value="${requestScope.Vender.product_license}" />
				</div>
				<div class="form-group">
					<label for="">工商注册号</label>
					<input class="form-input-txt" type="text" name="bussiness_registration_no" value="${requestScope.Vender.bussiness_registration_no}"  />
				</div>
				<div class="form-group">
					<label for="">注册资金</label>
					<input class="form-input-txt" type="text" name="registered_capital" value="${requestScope.Vender.registered_capital}" />
				</div>
				<div class="form-group">
					<label for="">操作人</label>
					<input class="form-input-txt" type="text" name="user_id" value="${requestScope.Vender.user_id}" />
				</div>
				<div class="form-group">
					<label for="">创建时间</label>
					<input class="form-input-txt" type="text" name="create_time" value="${requestScope.Vender.create_time}" />
				</div>
				<div class="form-group">
					<label for="">注销标志</label>
					<input class="form-input-txt" type="text" name="zxbj" value="${requestScope.Vender.zxbj}"  />
				</div>
				<div class="form-group">
					<label for="">备注</label>
					<input class="form-input-txt" type="text" name="remark" value="${requestScope.Vender.remark}" />
				</div>

				<div class="form-group" style="margin-left:150px;">
					<input type="submit" class="sub-btn" value="提  交" />
					<input type="reset" class="sub-btn" value="重  置" />
				</div>
				</form>
			</div>
		</div>
	</div>
<script src="../kingediter/kindeditor-all-min.js"></script>
<script src="../js/laydate.js"></script>
<script>
	 KindEditor.ready(function(K) {
                window.editor = K.create('#editor_id');
        });
</script>
</body>
</html>