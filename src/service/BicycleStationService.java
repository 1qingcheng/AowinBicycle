package service;
import dao.BicycleStationMapper;
import model.BicycleStation;
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
    public List<BicycleStation> getAllStation() {
        List<BicycleStation> list = bicycleStationMapper.getAllStation();
        return list;
    }
}
