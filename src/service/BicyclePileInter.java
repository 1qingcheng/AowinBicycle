package service;

import model.BicyclePile;
import model.Page;

import java.util.List;

public interface BicyclePileInter {
    List<BicyclePile> getPileByStation(int station_id, int condition, Page page);
    int getPilesTotalPage(int station_id,int condition,Page page);//得到车点的车桩数目
    List<BicyclePile> getPilesByStationId(int station_id);//根据车点id得到下面的所有车桩
    int addPiles(List<BicyclePile> bicyclePiles);//新增车点下的车桩


}
