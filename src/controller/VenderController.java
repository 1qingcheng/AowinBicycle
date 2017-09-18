package controller;

import model.Vender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.VenderInter;
import util.Util;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
//供应商管理
public class VenderController {
    @Resource
    private VenderInter venderService;

    public VenderInter getVenderService() {
        return venderService;
    }

    public void setVenderService(VenderInter venderService) {
        this.venderService = venderService;
    }

    //查询得到所有的供应商
    @RequestMapping("/getAllVender.do")
    public String getAllVender(HttpServletRequest request){
        List<Vender> list = venderService.getAllVender();
        request.setAttribute("venderList",list);
        return "/供应商管理/showAllVender.jsp";
    }

    //新增供应商
    @RequestMapping("/addVender.do")
    public String addVender(Vender vender){
        String date=Util.getTime();
        vender.setCreate_time(date);
        venderService.addVender(vender);
        return "/getAllVender.do";
    }


    //根据id查询
    @RequestMapping("/queryVenderById.do")
    public String queryVenderById(HttpServletRequest request){
        String vender_code=request.getParameter("vender_id");
        Vender vender=venderService.queryVenderById(Integer.valueOf(vender_code));
        request.setAttribute("Vender",vender);
        return "/供应商管理/changeVender.jsp";
    }

    //更新供应商
    @RequestMapping("/updateVender.do")
    public String updateVender(Vender vender){
        venderService.updateVender(vender);
        return "/getAllVender.do";
    }

    //注销供应商
    @RequestMapping("/logoutVender.do")
    public String logout(HttpServletRequest request){
        String vender_id=request.getParameter("vender_id");
        venderService.logout(vender_id);
        return "/getAllVender.do";
    }

}
