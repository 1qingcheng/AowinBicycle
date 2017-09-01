package dao;

import model.BicycleStation;

import java.util.List;

public interface BicycleStationMapper {
    int addBicycleStation(BicycleStation bicycleStation);//新增租车点(同时需要操作新增车桩)
    List<BicycleStation> queryStation(BicycleStation bicycleStation);//模糊查询租车点
    int updateBicycleStation(BicycleStation bicycleStation);//对查询出的车点进行修改，同时可以对该车点下的车桩进行修改
    List<BicycleStation> getAllStation();//查询得到所有的租车点


}
