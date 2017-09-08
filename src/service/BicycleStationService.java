package service;
import dao.BicycleStationMapper;
import model.BicycleStation;
import model.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class BicycleStationService implements BicycleStationInter {
    @Resource
    private BicycleStationMapper bicycleStationMapper;

    public BicycleStationMapper getBicycleStationMapper() {
        return bicycleStationMapper;
    }

    public void setBicycleStationMapper(BicycleStationMapper bicycleStationMapper) {
        this.bicycleStationMapper = bicycleStationMapper;
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
}
