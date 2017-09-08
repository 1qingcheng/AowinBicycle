
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
    alert(vender_type)
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
    window.location="/logout.do?vender_id="+vender_id;
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