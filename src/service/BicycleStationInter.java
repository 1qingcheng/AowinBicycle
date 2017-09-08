package service;

import model.BicycleStation;
import model.Page;

import java.util.List;

public interface BicycleStationInter {
    int getStationCount(Page page);//得到车点数目
    List<BicycleStation> getAllStation(Page page);//查询得到所有的车点
}
