package dao;

import model.BicycleStation;
import model.Page;

import java.util.List;

public interface BicycleStationMapper {
    int addBicycleStation(BicycleStation bicycleStation);//新增租车点(同时需要操作新增车桩)
    List<BicycleStation> queryStation(BicycleStation bicycleStation);//模糊查询租车点
    int updateBicycleStation(BicycleStation bicycleStation);//对查询出的车点进行修改，同时可以对该车点下的车桩进行修改
    List<BicycleStation> getAllStation(Page page);//查询得到当前页所有的租车点
    int getStationCount();//得到车点数目
    BicycleStation getStationById(int station_id);//根据id查询到车点
    int stationLogout(int station_id);//车点注销


}
