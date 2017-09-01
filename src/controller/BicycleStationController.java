package controller;

import model.BicycleStation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BicycleStationInter;
import service.BicycleStationService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BicycleStationController {
    @Resource
    private BicycleStationInter bicycleStationService;

    public BicycleStationInter getBicycleStationService() {
        return bicycleStationService;
    }

    public void setBicycleStationService(BicycleStationService bicycleStationService) {
        this.bicycleStationService = bicycleStationService;
    }

    //查询得到所有的车点
    @RequestMapping("/getAllStation.do")
    public String getAllStation(HttpServletRequest request){
        List<BicycleStation> stationList = bicycleStationService.getAllStation();
        request.setAttribute("stationList",stationList);
        return"/自行车租赁归还/choseStaion.jsp";
    }

}
