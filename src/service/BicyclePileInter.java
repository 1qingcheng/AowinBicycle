package service;

import model.BicyclePile;
import model.Page;

import java.util.List;

public interface BicyclePileInter {
    List<BicyclePile> getPileByStation(int station_id, int condition, Page page);
    int getPilesTotalPage(int station_id,int condition,Page page);//得到车点的车桩数目

}
