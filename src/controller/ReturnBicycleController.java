package controller;

import model.BicycleInfo;
import model.Card;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.RentBicycleInter;
import service.ReturnBicycleInter;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@Controller
public class ReturnBicycleController {
    @Resource
    private ReturnBicycleInter returnBicycleService;
    @Resource
    private RentBicycleInter rentBicycleService;

    public ReturnBicycleInter getReturnBicycleService() {
        return returnBicycleService;
    }

    public void setReturnBicycleService(ReturnBicycleInter returnBicycleService) {
        this.returnBicycleService = returnBicycleService;
    }
    public RentBicycleInter getRentBicycleService() {
        return rentBicycleService;
    }

    public void setRentBicycleService(RentBicycleInter rentBicycleService) {
        this.rentBicycleService = rentBicycleService;
    }

    //归还车辆
    @RequestMapping(value = "/returnBicycle.do",produces ="text/plain;charset=utf8" )
    @ResponseBody
    public String returnBicycle(HttpServletRequest request){
        String card_code=request.getParameter("card_code");
        String pile_id=request.getParameter("pile_id");
        Card card = rentBicycleService.verifyCardCode(card_code);//查询卡号是否存在
        if(card==null) {
            return "您的卡号不存在";
        }else{
            BicycleInfo bicycleInfo = rentBicycleService.verifyAlreadyRent(card);//验证是否有租车未还
            if(bicycleInfo==null){
                return "您没有需要归还的自行车";
            }
        }

        try {
            String message=returnBicycleService.returnBicycle(card,Integer.valueOf(pile_id));
            return message;
        } catch (ParseException e) {
            return "系统异常";
        }

    }
}


