package service;

import dao.RentBicycleMapper;
import model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import util.Util;

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


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int rentBicycle(Card card,int pile_id) {

        double frozenMoney=rentBicycleMapper.queryFrozenMoney(card);
        double moneyChanged=0;
        if(frozenMoney==0){
            rentBicycleMapper.updateFrozenMoney(200,card);
            moneyChanged=200;
        }else if(frozenMoney>0 && frozenMoney<200){
            rentBicycleMapper.updateFrozenMoney(200-frozenMoney,card);
            moneyChanged=200-frozenMoney;
        }
        rentBicycleMapper.updateBicycleInfo(card,pile_id);//将该车桩的车辆状态改成（2：借出）
        rentBicycleMapper.updatePileStatus(pile_id);//将车桩状态改成（2：无车）
        String time= Util.getTime();//得到当前时间
        if(moneyChanged!=0){
            CardRecord cardRecord=new CardRecord();
            cardRecord.setCard_id(card.getCard_id());
            cardRecord.setFee_type(4);//4为消费
            cardRecord.setChg_monthly_money(0);
            cardRecord.setChg_wallet_money(-moneyChanged);
            cardRecord.setChg_frozen_money(moneyChanged);
            cardRecord.setCreate_time(time);
//            cardRecord.setUser_id(1);
            cardRecord.setRemark("frozen money changed");
            cardRecord.setZxbj(0);
            rentBicycleMapper.addCardRecord(cardRecord);//若有冻结金额变动 需要将变动信息记录在卡费用流水表中
        }

        //需要在车辆租还记录表中增加一条租车记录。
        BicycleInfo bicycleInfo = rentBicycleMapper.verifyAlreadyRent(card);
        BicycleRecord bicycleRecord=new BicycleRecord();
        bicycleRecord.setBicycle_id(bicycleInfo.getBicycle_id());
        bicycleRecord.setCard_id(card.getCard_id());
        bicycleRecord.setRent_time(time);
        bicycleRecord.setRent_pile_id(pile_id);
        rentBicycleMapper.addBicycleRecord(bicycleRecord);

        //新增车辆业务流水表记录
        BicycleDeal bicycleDeal=new BicycleDeal();
        bicycleDeal.setCreate_time(time);
        bicycleDeal.setDeal_name("rent");
        bicycleDeal.setDeal_type("2");//2为租车
        bicycleDeal.setRecord_id(bicycleRecord.getRecord_id());
        bicycleDeal.setCard_id(card.getCard_id());
        bicycleDeal.setIs_fee("0");//0为未发生
        bicycleDeal.setChg_money(0);
        bicycleDeal.setFee_type(3);//3为租车
        bicycleDeal.setBicycle_id(bicycleInfo.getBicycle_id());
        bicycleDeal.setPile_id(pile_id);
        //bicycleDeal.setUser_id(1);
        rentBicycleMapper.addBicycleDeal(bicycleDeal);

        return 1;
    }


}
