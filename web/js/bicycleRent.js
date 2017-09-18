
//租车输入卡号验证
function rentCardIdInput(obj) {
    var card_code=prompt("请输入您的卡号");
    var reg=/^[1-9]\d{0,14}$/;
    if(card_code!=null){
        if(reg.test(card_code)){
            var pile_id=$(obj).siblings().eq(0).val();
            $.post("/rentBicycle.do",{card_code:card_code,pile_id:pile_id},function (data) {
                alert(data);
            },"text")
        }else{
            alert("您输入的号码格式有误")
        }
    }
}

// 添加供应商的时候验证输入
function venderCodeReg() {
    var vender_code=$("[name='vender_code']:first").val();
    var regCode=/[0-9a-zA-Z]{1,10}/;
    if(!regCode.test(vender_code)){
        alert("供应商编号输入格式有误");
    }
}

function venderTypeReg() {
    var vender_type=$("[name='vender_type']:first").val();
    if(vender_type!=1&&vender_type!=2){
        alert("类型输入仅能为1或者为2");
    }
}

//跳转至修改页面
function goChange(obj) {
    var vender_id=obj.parentNode.parentNode.childNodes[1].value;
    window.location="/queryVenderById.do?vender_id="+vender_id;
}

//注销供应商
function goLogOut(obj) {
    var vender_id=obj.parentNode.parentNode.childNodes[1].value;
    window.location="/logoutVender.do?vender_id="+vender_id;
}

//还车输入卡号验证
function returnCardIdInput(obj) {
    var card_code=prompt("请输入您的卡号");
    var reg=/^[1-9]\d{0,14}$/;
    if(card_code!=null){
        if(reg.test(card_code)){
            var pile_id=$(obj).siblings().eq(0).val();
            $.post("/returnBicycle.do",{card_code:card_code,pile_id:pile_id},function (data) {
                alert(data);
            },"text")
        }else{
            alert("您输入的号码格式有误")
        }
    }
}



//车辆租赁的时候车点分页跳转
function goToRentStation(obj) {
    var reg=/\d/;
    var currentPage=$(obj).prev().val();
    if(reg.test(currentPage)){
        $("#currentPageForm").attr("action","/getAllStation.do?currentPage="+currentPage+"&message=rent");
        $("#currentPageForm").attr("method","post");
        $("#currentPageForm").submit();
    }else{
        alert("请输入正确的页码");
    }

}
//车辆归还的时候车点分页跳转
function goToReturnStation(obj) {
    var reg=/\d/;
    var currentPage=$(obj).prev().val();
    if(reg.test(currentPage)){
        $("#currentReturnPageForm").attr("action","/getAllStation.do?currentPage="+currentPage+"&message=return");
        $("#currentReturnPageForm").attr("method","post");
        $("#currentReturnPageForm").submit();
    }else{
        alert("请输入正确的页码");
    }
}

//车点查询时的输入验证
function stationCodeReg(obj) {
    var reg=/^[0-9A-Za-z]{1,10$}/;
    alert(station_code)
    if(!reg.test(station_code)){
        alert("您的输入不符合格式");
    }
}

function stationNameReg(obj) {
    var reg=/^\w{1,25}$/;
    var station_name=$(obj).val();
    if(!reg.test(station_name)){
        alert("您的输入不符合格式");
    }
}

function stationPersonInChargeReg(obj) {
    var reg = /^\w{1,7}$/;
    var person = $(obj).val();
    if (!reg.test(person)) {
        alert("您的输入不符合格式");
    }
}

//新增车点的时候增加一条车桩
var i=0;
function addPile() {
    $("#pileDiv").css("display","block");
    $("#pileDetail").append(
        "<tr>" +
        "<td><input type='text' name='bicyclePile["+i+"].pile_code'></td>" +
        "<td><input type='text' name='bicyclePile["+i+"].vender_id'></td>" +
        "<td><input type='text' name='bicyclePile["+i+"].status'></td>" +
        "<td><input type='text' name='bicyclePile["+i+"].install_time'></td>" +
        "<td><input type='text' name='bicyclePile["+i+"].bicycle_id'></td>" +
        "<td><input type='text' name='bicyclePile["+i+"].remark'></td>" +
        "<td onclick='deletePile(this)' style='cursor: hand;color: red'>x</td>"+
        "</tr>"
    )
    i++;
}

function addStation() {
    var param=$("#addStation").serialize();
    $.ajax({
        url:"/addStation.do",
        type:"post",
        data:param,
        success:function (msg) {
            alert(msg);
        }
    })
}

function deletePile(obj) {
    $(obj).parent().remove();
}

function queryReport() {
    var year_month={'minMonth':$("[name='minMonth']:eq(0)").val()};
    $.ajax({
        url:"/queryReport.do",
        type:"post",
        data:year_month,
        success:function (msg) {
            var jsonObject=JSON.parse(msg);
            $("#reportTable").append(
            "<tr><th style='width:5%'>车辆数量</th><th style='width:5%'>借还次数</th><th style='width:5%'>修理次数</th><th style='width:5%'>当月平均收入</th><th style='width:5%'>当月总收入</th><th style='width:5%'>当月平均修理费用</th><th style='width:5%'>当月总修理费用</th></tr>"+
                "<tr style='text-align: center'>" +
                "<td>"+jsonObject['bicycleCount']+"</td>" +
                "<td>"+jsonObject['rentReturnCount']+"</td>" +
                "<td>"+jsonObject['repairCount']+"</td>" +
                "<td>"+jsonObject['incomeAVG']+"</td>" +
                "<td>"+jsonObject['incomeTotal']+"</td>" +
                "<td>"+jsonObject['repairAVG']+"</td>" +
                "<td>"+jsonObject['repairTotal']+"</td>" +
                "</tr>"
            )
        }
    })
}

