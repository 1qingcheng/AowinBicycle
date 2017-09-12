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
    <title>车点查询</title>
    <link rel="stylesheet" href="/css/reset.css" />
    <link rel="stylesheet" href="/css/content.css" />
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bicycleRent.js"></script>
<body marginwidth="0" marginheight="0">
<div class="container">
    <div class="public-nav">您当前的位置:车点查询</div>

    <div class="public-content">
        <form action="/queryStation.do" method="post">
        <div class="form-group"><label for="">车点编号</label><input class="form-input-txt" type="text" name="station_code" placeholder="1-10位的数字或字母" onchange="stationCodeReg(this)"/>
        </div>
        <div class="form-group">
            <label for="">车点名称</label>
            <input class="form-input-txt" type="text" name="station_name" placeholder="1-25个字符"  onchange="stationNameReg(this)"/>
        </div>
        <div class="form-group">
            <label for="">负责人</label>
            <input class="form-input-txt" type="text" name="person_in_charge" placeholder="1-7个汉字"  onchange="stationPersonInChargeReg(this)"/>
        </div>
        <div class="form-group">
            <label for="">地址</label>
            <input class="form-input-txt" type="text" name="address"  />
        </div>
        <div class="form-group" style="margin-left:150px;">
            <input type="submit" class="sub-btn" value="提  交" />
            <input type="reset" class="sub-btn" value="重  置" />
        </div>
    </form>


        <div class="public-content-cont">
        <c:if test="${not empty list}" >
            <table class="public-cont-table">
                <tr>
                    <th style="width:5%">车点编号</th>
                    <th style="width:5%">车点名称</th>
                    <th style="width:5%">车点经度</th>
                    <th style="width:5%">车点纬度</th>
                    <th style="width:5%">车点车桩数量</th>
                    <th style="width:20%">地址</th>
                    <th style="width:20%">负责人</th>
                    <th style="width:20%">备注</th>
                    <th style="width:20%">操作</th>
                </tr>
                <c:forEach items="${list}" var="station">
                    <tr style="border: solid">
                        <td>${station.station_code}</td>
                        <td><a href="/getPileByStation.do?station_id=${station.station_id}&station_name=${station.station_name}">${station.station_name}</a></td>
                        <td>${station.longitude}</td>
                        <td>${station.latitude}</td>
                        <td>${station.bicycle_pile_num}</td>
                        <td>${station.address}</td>
                        <td>${station.person_in_charge}</td>
                        <td>${station.remark}</td>
                        <td><a href="/getStationById.do?station_id=${station.station_id}">修改</a> <a onclick="stationLogout()" style="cursor: hand">注销</a></td>
                        <script>
                            function stationLogout() {
                                $.post("/logoutStation.do",{station_id:${station.station_id}},function (data) {
                                    alert(data);
                                },"text");
                            }
                        </script>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        </div>
    </div>
</div>
</body>
</html>
