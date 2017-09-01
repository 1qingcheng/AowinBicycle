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

    public BicycleStationService getBicycleStationService() {
        return bicycleStationService;
    }

    public void setBicycleStationService(BicycleStationService bicycleStationService) {
        this.bicycleStationService = bicycleStationService;
    }

    //查询得到所有的车点
    @RequestMapping()
    public String getAllStation(){
        List<BicycleStation> list = bicycleStationService.getAllStation();
        return"/自行车租赁归还/bicycleRent.jsp"+list;
    }

}
