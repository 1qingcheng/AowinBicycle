package controller;

import model.BicycleInfo;
import model.Card;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("/rentBicycle.do")
    public String rentBicycle(HttpServletRequest request){
        String card_code=request.getParameter("card_code");
        Card card = rentBicycleService.verifyCardCode(card_code);
        if(card==null){
            return "您的卡号不存在";
        }else{
            Double money=rentBicycleService.verifyCardMoney(card);
            if(money<200){
                return "您的钱包余额不足，请先充值";
            }else{
                BicycleInfo info = rentBicycleService.verifyAlreadyRent(card);
                if(info!=null){
                    return "您有尚未归还的自行车，请先归还";
                }
            }
        }
        return "借车成功";
    }



}
