package controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ReportInter;
import util.Util;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ReportController {
    @Resource
    private ReportInter reportService;

    public ReportInter getReportService() {
        return reportService;
    }

    public void setReportService(ReportInter reportService) {
        this.reportService = reportService;
    }

    //根据年月查询报表
    @RequestMapping(value = "/queryReport.do",produces = "text/plain;charset=utf8")
    @ResponseBody
    public String queryReport(HttpServletRequest request){
        String minDate=request.getParameter("minMonth");
        String maxDate=null;
        try {
            Date date=Util.changeStringToMonth(minDate);
            date.setMonth(date.getMonth()+1);
            maxDate=Util.changeMonthToString(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int bicycleCount=reportService.getBicycleCount();//车辆数量(在桩的与借出的)
        int rentReturnCount=reportService.getRentReturnCount(minDate,maxDate);//借还次数
        int repairCount=reportService.getRepairCount(minDate,maxDate);//修理次数
        double incomeAVG=reportService.getAvgIncomeByMonth(minDate,maxDate);//当月平均收入
        double incomeTotal=reportService.getTotalIncomeByMonth(minDate,maxDate);//当月总收入
        double repairAVG=reportService.getRepairAvg(minDate,maxDate);//平均修理费用
        double repairTotal=reportService.getRepairTotal(minDate,maxDate);//总修理费用
        Map map=new HashMap();
        map.put("bicycleCount",bicycleCount);
        map.put("rentReturnCount",rentReturnCount);
        map.put("repairCount",repairCount);
        map.put("incomeAVG",incomeAVG);
        map.put("incomeTotal",incomeTotal);
        map.put("repairAVG",repairAVG);
        map.put("repairTotal",repairTotal);
        ObjectMapper mapper = new ObjectMapper();
        String message= null;
        try {
            message = mapper.writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  message;
    }

}
