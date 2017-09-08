package service;

import dao.BicyclePileMapper;
import model.BicyclePile;
import model.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BicyclePileService implements BicyclePileInter {
    @Resource
    private BicyclePileMapper bicyclePileMapper;

    public BicyclePileMapper getBicyclePileMapper() {
        return bicyclePileMapper;
    }

    public void setBicyclePileMapper(BicyclePileMapper bicyclePileMapper) {
        this.bicyclePileMapper = bicyclePileMapper;
    }

    @Override
    //根据车点id查询下面的车桩,租车时condition为1，还车时condition为2
    public List<BicyclePile> getPileByStation(int station_id, int condition, Page page) {
        return bicyclePileMapper.getPileByStation(station_id,condition,page);
    }

    //得到车点的车桩总页数
    @Override
    public int getPilesTotalPage(int station_id,int condition,Page page) {
        int total=bicyclePileMapper.getPilesCount(station_id,condition);
        int totalPage=total % page.getPageSize() == 0 ? total / page.getPageSize() : total / page.getPageSize() + 1;
        return totalPage;
    }


}
