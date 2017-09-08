package dao;

import model.BicyclePile;
import model.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BicyclePileMapper {
    int addBicyclePile(List<BicyclePile> list);//新增车点的时候批量添加车桩
    List<BicyclePile> getPileByStation(@Param("station_id") int station_id, @Param("condition") int condition, @Param("page")Page page);//租车时根据车点id获得下面有车的车桩,还车时获得下面无车的车桩
    int getPilesCount(@Param("station_id") int station_id,@Param("condition")int condition);//得到车桩总数目


}
