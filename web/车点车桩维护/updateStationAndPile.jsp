<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2017/9/8
  Time: 下午2:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>车点车桩更新</title>
    <link rel="stylesheet" href="/css/reset.css" />
    <link rel="stylesheet" href="/css/content.css" />
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bicycleRent.js"></script>
<body marginwidth="0" marginheight="0">
    <div class="container">
        <div class="public-nav">您当前的位置:车点车桩修改</div>
        <div class="public-content-cont">
            <form action="/updateStation.do" method="post">
            <table class="public-cont-table">
                <tr>
                    <th style="width:5%">车点编号</th>
                    <th style="width:5%">车点名称</th>
                    <th style="width:5%">车点经度</th>
                    <th style="width:5%">车点纬度</th>
                    <th style="width:20%">地址</th>
                    <th style="width:20%">负责人</th>
                    <th style="width:20%">备注</th>
                </tr>
                <tr>
                    <input type="hidden" name="station_id" value="${station.station_id}">
                    <td><input type="text" value="${station.station_code}" name="station_code"></td>
                    <td><input type="text" value="${station.station_name}" name="station_name"></td>
                    <td><input type="text" value="${station.longitude}" name="longitude"></td>
                    <td><input type="text" value="${station.latitude}" name="latitude"></td>
                    <td><input type="text" value="${station.address}" name="address"></td>
                    <td><input type="text" value="${station.person_in_charge}" name="person_in_charge"></td>
                    <td><input type="text" value="${station.remark}" name="remark"></td>
                    <input type="hidden" name="bicycle_pile_num" value="${station.bicycle_pile_num}">
                    <input type="hidden" name="build_time" value="${station.build_time}">
                    <input type="hidden" name="run_time" value="${station.run_time}">
                    <input type="hidden" name="user_id" value="${station.user_id}">
                </tr>
            </table>

            <table class="public-cont-table">
                <tr>
                    <th style="width:5%">车桩编号</th>
                    <th style="width:5%">车桩供应商</th>
                    <th style="width:5%">状态</th>
                    <th style="width:5%">安装日期</th>
                    <th style="width:20%">所存车辆编号</th>
                    <th style="width:20%">备注</th>
                </tr>
                <c:forEach items="${station.bicyclePile}" var="pile" varStatus="index">
                    <tr>
                        <input type="hidden" name="bicyclePile[${index.index}].pile_id" value="${pile.pile_id}">
                        <td><input type="text" value="${pile.pile_code}" name="bicyclePile[${index.index}].pile_code"></td>
                        <td><input type="text" value="${pile.vender_id}" name="bicyclePile[${index.index}].vender_id"></td>
                        <td><input type="text" value="${pile.status}" name="bicyclePile[${index.index}].status"></td>
                        <td><input type="text" value="${pile.install_time}" name="bicyclePile[${index.index}].install_time"></td>
                        <td><input type="text" value="${pile.bicycle_id}" name="bicyclePile[${index.index}].bicycle_id"></td>
                        <td><input type="text" value="${pile.remark}" name="bicyclePile[${index.index}].remark"></td>
                    </tr>
                </c:forEach>
            </table>
            <div><input type="submit" value="提交"></div>
            </form>
        </div>

    </div>


</body>
</html>
