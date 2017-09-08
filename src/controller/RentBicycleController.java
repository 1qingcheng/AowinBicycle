package controller;

import model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.RentBicycleInter;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller

public class RentBicycleController {
    @Resource
    private RentBicycleInter rentBicycleService;

    public RentBicycleInter getRentBicycleService() {
        return rentBicycleService;
    }

    public void setRentBicycleService(RentBicycleInter rentBicycleService) {
        this.rentBicycleService = rentBicycleService;
    }

    //根据卡编码验证是否该卡存在,验证卡金额是否满足条件  (冻结金额+钱包余额)>=200,验证是否已经租车
    @RequestMapping(value = "/rentBicycle.do",produces ="text/plain;charset=utf8" )
    @ResponseBody
    public String rentBicycle(HttpServletRequest request){
        String card_code=request.getParameter("card_code");
        String pile_id=request.getParameter("pile_id");
        Card card = rentBicycleService.verifyCardCode(card_code);//验证卡号
        if(card==null){
            return "您的卡号不存在";
        }else{
            Double money=rentBicycleService.verifyCardMoney(card);
            if(money<200){
                return "您的钱包余额不足，请先充值";
            }else{
                BicycleInfo bicycle_info = rentBicycleService.verifyAlreadyRent(card);//验证是否有租车
                if(bicycle_info!=null){
                    return "您有尚未归还的自行车，请先归还";
                }
            }
        }
        rentBicycleService.rentBicycle(card,Integer.valueOf(pile_id));
        return "借车成功";

    }
}
