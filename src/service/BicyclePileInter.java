package service;

import model.BicyclePile;

import java.util.List;

public interface BicyclePileInter {
    List<BicyclePile> getPileByStation(String station_id);
}
