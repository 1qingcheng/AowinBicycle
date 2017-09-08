package service;

import model.*;

public interface RentBicycleInter {
    Card verifyCardCode(String card_code);//根据卡编码验证是否该卡存在
    double verifyCardMoney(Card card);//根据卡编码验证卡金额是否满足条件  (冻结金额+钱包余额)>=200
    BicycleInfo verifyAlreadyRent(Card card);//根据卡编码验证是否已经租车
    int rentBicycle(Card card,int pile_id);//出租车辆后的一些数据库操作，需要事务处理
}
