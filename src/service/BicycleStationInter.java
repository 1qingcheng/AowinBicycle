package service;

import model.BicycleStation;
import model.Page;

import java.util.List;

public interface BicycleStationInter {
    int getStationCount(Page page);//得到车点数目
    List<BicycleStation> getAllStation(Page page);//查询得到所有的车点
    List<BicycleStation> queryStation(BicycleStation bicycleStation);//车点的模糊查询
    BicycleStation getStationById(int station_id);//根据id查询到车点
    int updateBicycleStation(BicycleStation bicycleStation);//对查询出的车点进行修改
    int stationLogout(int station_id);//根据车点编号进行注销，若车点有车不能注销
    int addStation(BicycleStation bicycleStation,String time);//新增车点

}
