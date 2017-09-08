package controller;

import model.BicycleStation;
import model.Page;
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

        String currentPage = request.getParameter("currentPage");
        if(currentPage==null){
            currentPage="1";
        }

        Page page=new Page(); //封装page对象
        page.setCurrentPage(Integer.valueOf(currentPage));
        page.setPageSize(3);
        int start=(page.getCurrentPage()-1)*page.getPageSize();
        page.setStart(start);
        int totalPage=bicycleStationService.getStationCount(page);
        page.setTotalPage(totalPage);
        List<BicycleStation> stationList = bicycleStationService.getAllStation(page);
        page.setData(stationList);
        request.setAttribute("page",page);
        String message=request.getParameter("message");
        if("rent".equals(message)){
            return"/自行车租赁/choseStaion.jsp";
        }
        return "/自行车归还/choseStaion.jsp";
    }

}
