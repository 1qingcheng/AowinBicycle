package service;

import dao.BicycleOrderMapper;
import model.BicycleOrder;
import org.springframework.stereotype.Service;

@Service
public class BicycleOrderService implements BicycleOrderInter {
     private BicycleOrderMapper bicycleOrderMapper;

    public BicycleOrderMapper getBicycleOrderMapper() {
        return bicycleOrderMapper;
    }

    public void setBicycleOrderMapper(BicycleOrderMapper bicycleOrderMapper) {
        this.bicycleOrderMapper = bicycleOrderMapper;
    }

    /**
     * 增加主信息表
     * @param bicycleOrder
     */
    @Override
    public void add(BicycleOrder bicycleOrder) {
        bicycleOrderMapper.insert(bicycleOrder);
    }
}