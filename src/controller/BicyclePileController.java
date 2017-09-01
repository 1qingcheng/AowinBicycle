package controller;

import model.BicyclePile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BicyclePileInter;
import service.BicyclePileService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BicyclePileController {
    @Resource
    private BicyclePileInter bicyclePileService;

    public BicyclePileInter getBicyclePileService() {
        return bicyclePileService;
    }

    public void setBicyclePileService(BicyclePileService bicyclePileService) {
        this.bicyclePileService = bicyclePileService;
    }

    //根据BicycleStation id 查询其下面有车的车桩
    @RequestMapping("/getPileByStation.do")
    public String getPileByStation(HttpServletRequest request){
        String station_id=request.getParameter("station_id");
        String station_name=request.getParameter("station_name");
        List<BicyclePile> pileList = bicyclePileService.getPileByStation(station_id);
        request.setAttribute("pileList",pileList);
        return "/自行车租赁归还/chosePile.jsp?station_name="+station_name;
    }

}
