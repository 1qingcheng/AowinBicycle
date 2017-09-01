package service;

import dao.BicyclePileMapper;
import model.BicyclePile;
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
    //根据车点id查询下面的车桩
    public List<BicyclePile> getPileByStation(String station_id) {
        return bicyclePileMapper.getPileByStation(station_id);
    }
}
