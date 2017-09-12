<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2017/9/8
  Time: 上午9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>车辆费用统计</title>
    <link rel="stylesheet" href="/css/reset.css" />
    <link rel="stylesheet" href="/css/content.css" />
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bicycleRent.js"></script>
<body marginwidth="0" marginheight="0">
<div class="container">
    <div class="public-nav">您当前的位置:车辆费用统计</div>

    <div class="public-content" align="center">
        <form  id="reportForm">
            <div>
                请先选择查询月份
                <input type="month" name="minMonth">
            </div>

            <div class="form-group">
                <input type="button" onclick="queryReport()" class="sub-btn" value="提  交" />
                <input type="reset" class="sub-btn" value="重  置" />
            </div>
        </form>
    </div>


        <div class="public-content-cont" style="margin-top: 50px">
            <table class="public-cont-table" id="reportTable">

            </table>
        </div>
    </div>
</div>
</body>
</html>
