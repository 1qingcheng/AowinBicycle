function cardidInput() {
    var card_code=prompt("请输入您的卡号");
    var reg=/^[1-9]\d{0,14}$/;
    if(card_code!=null){
        if(reg.test(card_code)){
            $.post("/rentBicycle.do",{card_code:card_code},function (data) {
                alert(data);
            },"text")
        }else{
            alert("您输入的号码格式有误")
        }
    }

    // $("[name='card_code']:first").val(card_id);


}