package service;

import dao.RentBicycleMapper;
import model.BicycleInfo;
import model.Card;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class RentBicycleService implements RentBicycleInter {
    @Resource
    private RentBicycleMapper rentBicycleMapper;

    public RentBicycleMapper getRentBicycleMapper() {
        return rentBicycleMapper;
    }

    public void setRentBicycleMapper(RentBicycleMapper rentBicycleMapper) {
        this.rentBicycleMapper = rentBicycleMapper;
    }

    //根据卡编码验证是否该卡存在
    @Override
    public Card verifyCardCode(String card_code) {
        return rentBicycleMapper.verifyCardCode(card_code);
    }

    //根据卡编码验证卡金额是否满足条件  (冻结金额+钱包余额)>=200
    @Override
    public double verifyCardMoney(Card card) {
        return rentBicycleMapper.verifyCardMoney(card);
    }

    //根据卡编码验证是否已经租车
    @Override
    public BicycleInfo verifyAlreadyRent(Card card) {
        return rentBicycleMapper.verifyAlreadyRent(card);
    }
}
