package service;

import model.Vender;

import java.util.List;

public interface VenderInter {
    List<Vender> getAllVender();
    int addVender(Vender vender);
    Vender queryVenderById(int vender_id);
    int updateVender(Vender vender);
    int logout(Vender vender);
}
