package service;
import dao.BicyclePileMapper;
import dao.BicycleStationMapper;
import model.BicycleStation;
import model.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BicycleStationService implements BicycleStationInter {
    @Resource
    private BicycleStationMapper bicycleStationMapper;
    @Resource
    private BicyclePileMapper bicyclePileMapper;

    public BicycleStationMapper getBicycleStationMapper() {
        return bicycleStationMapper;
    }

    public void setBicycleStationMapper(BicycleStationMapper bicycleStationMapper) {
        this.bicycleStationMapper = bicycleStationMapper;
    }

    public BicyclePileMapper getBicyclePileMapper() {
        return bicyclePileMapper;
    }

    public void setBicyclePileMapper(BicyclePileMapper bicyclePileMapper) {
        this.bicyclePileMapper = bicyclePileMapper;
    }

    @Override
    public int getStationCount(Page page) {
        int total=bicycleStationMapper.getStationCount();
        int totalPage=total % page.getPageSize() == 0 ? total / page.getPageSize() : total / page.getPageSize() + 1;
        return totalPage;
    }

    @Override
    public List<BicycleStation> getAllStation(Page page) {
        List<BicycleStation> list = bicycleStationMapper.getAllStation(page);
        return list;
    }

    @Override
    public List<BicycleStation> queryStation(BicycleStation bicycleStation) {
        return bicycleStationMapper.queryStation(bicycleStation);
    }

    @Override
    public BicycleStation getStationById(int station_id) {
        return bicycleStationMapper.getStationById(station_id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateBicycleStation(BicycleStation bicycleStation) {
        bicycleStationMapper.updateBicycleStation(bicycleStation);
        bicyclePileMapper.updatePilesByStation(bicycleStation.getBicyclePile());
        return 1;
    }

    @Override
    public int stationLogout(int station_id) {
        return bicycleStationMapper.stationLogout(station_id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addStation(BicycleStation bicycleStation,String time) {
        bicycleStationMapper.addBicycleStation(bicycleStation);
        for(int i=0;i<bicycleStation.getBicyclePile().size();i++){
            bicycleStation.getBicyclePile().get(i).setStation_id(bicycleStation.getStation_id());
            bicycleStation.getBicyclePile().get(i).setOperator_time(time);
        }
        bicyclePileMapper.addBicyclePile(bicycleStation.getBicyclePile());
        return 1;
    }
}
