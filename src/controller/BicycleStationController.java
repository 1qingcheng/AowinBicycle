package controller;

import model.BicycleStation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BicycleStationService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class BicycleStationController {
    @Resource
    private BicycleStationService bicycleStationService;

    /**
     * 查询所有车点
     * @return
     */
    @RequestMapping("/getAllStation.do")
    public String getAllStation(){
        List<BicycleStation> list = bicycleStationService.getAllStation();
        return"/自行车租赁归还/bicycleRent.jsp"+list;
    }

}
