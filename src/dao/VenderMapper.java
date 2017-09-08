package dao;

import model.Vender;

import java.util.List;

public interface VenderMapper {

    List<Vender> getAllVender();//查询得到所有的供应商
    int addVender(Vender vender);//新增供应商
    Vender queryVenderById(int vender_id);
    int updateVender(Vender vender);
    int logout(Vender vender);
}