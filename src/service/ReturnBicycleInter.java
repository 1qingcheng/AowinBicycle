package service;

import model.Card;

import java.text.ParseException;

public interface ReturnBicycleInter {

    String returnBicycle(Card card,int pile_id) throws ParseException;//还车

}
