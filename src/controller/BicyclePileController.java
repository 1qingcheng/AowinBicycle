package controller;

import model.BicyclePile;
import model.BicycleStation;
import model.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.BicyclePileInter;
import service.BicyclePileService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BicyclePileController {
    @Resource
    private BicyclePileInter bicyclePileService;
    private Page page=new Page();

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
        String condition=request.getParameter("condition");

        String currentPage = request.getParameter("currentPage");
        if(currentPage==null){
            currentPage="1";
        }

        page.setCurrentPage(Integer.valueOf(currentPage));
        page.setPageSize(3);
        int start=(page.getCurrentPage()-1)*page.getPageSize();
        page.setStart(start);
        int totalPage=bicyclePileService.getPilesTotalPage(Integer.valueOf(station_id),Integer.valueOf(condition),page);
        page.setTotalPage(totalPage);
        List<BicyclePile> pileList = bicyclePileService.getPileByStation(Integer.valueOf(station_id),Integer.valueOf(condition),page);
        page.setData(pileList);
        request.setAttribute("page",page);

        if("1".equals(condition)){
            return "/自行车租赁/chosePile.jsp?station_id="+station_id+"&station_name="+station_name;
        }else if("2".equals(condition)){
            return "/自行车归还/chosePile.jsp?station_id="+station_id+"&station_name="+station_name;
        }
        return "/error.jsp";
    }



}
