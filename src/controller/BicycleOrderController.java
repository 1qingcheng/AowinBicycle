package controller;
import com.alibaba.fastjson.JSONArray;
import model.BicycleOrder;
import model.Vender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.BicycleOrderService;
import service.VenderService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BicycleOrderController {
    @Resource
    private BicycleOrderService bicycleOrderService;
    private VenderService venderService;

    /**
     * 添加主单
     * @param bicycleOrder
     * @return 成功返回success
     */
    @RequestMapping("/addbicycleorder.do")
    public @ResponseBody String addBicycleOrder(BicycleOrder bicycleOrder){
        bicycleOrderService.add(bicycleOrder);
        return "success";
    }

    @RequestMapping("/queryvender.do")
    public  @ResponseBody String addBicycleOrder(HttpServletRequest request){
        List<Vender> venders=venderService.query();
        request.setAttribute("venders",venders);
        String json= JSONArray.toJSONString(venders);
        return json;
    }
}
