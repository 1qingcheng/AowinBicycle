package controller;

import model.BicyclePile;
import model.BicycleStation;
import model.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.BicyclePileInter;
import service.BicycleStationInter;
import service.BicycleStationService;
import util.Util;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BicycleStationController {
    @Resource
    private BicycleStationInter bicycleStationService;
    @Resource
    private BicyclePileInter bicyclePileService;

    public BicycleStationInter getBicycleStationService() {
        return bicycleStationService;
    }

    public void setBicycleStationService(BicycleStationService bicycleStationService) {
        this.bicycleStationService = bicycleStationService;
    }

    public BicyclePileInter getBicyclePileService() {
        return bicyclePileService;
    }

    public void setBicyclePileService(BicyclePileInter bicyclePileService) {
        this.bicyclePileService = bicyclePileService;
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
        }else if("return".equals(message)){
            return "/自行车归还/choseStaion.jsp";
        }
        return "/车点车桩维护/showAllStation.jsp";
    }

    //车点的模糊查询
    @RequestMapping("/queryStation.do")
    public String queryStation(BicycleStation bicycleStation,HttpServletRequest request){
        List<BicycleStation> list=bicycleStationService.queryStation(bicycleStation);
        request.setAttribute("list",list);
        return "/车点车桩维护/queryStation.jsp";
    }



    //车点的维护修改，根据车点id得到该车点与下面的车桩信息
    @RequestMapping("/getStationById.do")
    public String getStationById(HttpServletRequest request){
        int station_id=Integer.valueOf(request.getParameter("station_id"));
        BicycleStation station = bicycleStationService.getStationById(station_id);
        List<BicyclePile> piles = bicyclePileService.getPilesByStationId(station_id);
        station.setBicyclePile(piles);
        request.setAttribute("station",station);
        return "/车点车桩维护/updateStationAndPile.jsp";
    }

    @RequestMapping("/updateStation.do")
    public String updateStation(BicycleStation bicycleStation){
        bicycleStation.setCreate_time(Util.getTime());
        bicycleStationService.updateBicycleStation(bicycleStation);
        return "/车点车桩维护/queryStation.jsp";
    }


    //车点注销
    @RequestMapping(value = "/logoutStation.do",produces = "text/plain;charset=utf8")
    @ResponseBody
    public String logoutStation(HttpServletRequest request){
        String station_id=request.getParameter("station_id");
        BicycleStation bicycleStation=bicycleStationService.getStationById(Integer.valueOf(station_id));
        List<BicyclePile> pileList = bicyclePileService.getPilesByStationId(Integer.valueOf(station_id));
        if(bicycleStation!=null && pileList==null){
            bicycleStationService.stationLogout(Integer.valueOf(station_id));
            return "注销成功";
        }else if(bicycleStation!=null && pileList!=null){
            return "车点下有车辆，不得注销";
        }
        return "注销失败";
    }



    //车点车桩新增
    @RequestMapping(value = "/addStation.do",produces = "text/plain;charset=utf8")
    @ResponseBody
    public String addStation(BicycleStation bicycleStation){
        bicycleStation.setBicycle_pile_num(bicycleStation.getBicyclePile().size());
        String time=Util.getTime();
        bicycleStation.setCreate_time(time);
        bicycleStation.setZxbj("1");
        bicycleStationService.addStation(bicycleStation,time);
        return "添加成功";
    }
}
