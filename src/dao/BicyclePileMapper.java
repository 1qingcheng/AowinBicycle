package dao;

import model.BicyclePile;
import java.util.List;

public interface BicyclePileMapper {
    int addBicyclePile(List<BicyclePile> list);//新增车点的时候批量添加车桩

}
