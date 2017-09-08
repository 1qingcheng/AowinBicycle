package service;

import dao.ReturnBicycleMapper;
import model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import util.Util;
import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;

@Service
public class ReturnBicycleService implements ReturnBicycleInter {
    @Resource
    private ReturnBicycleMapper returnBicycleMapper;

    public ReturnBicycleMapper getReturnBicycleMapper() {
        return returnBicycleMapper;
    }

    public void setReturnBicycleMapper(ReturnBicycleMapper returnBicycleMapper) {
        this.returnBicycleMapper = returnBicycleMapper;
    }

    //还车
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String returnBicycle(Card card, int pile_id) throws ParseException {

        BicycleRecord bicycleRecord=returnBicycleMapper.getBicycleRecord(card);//获得租车记录计算租车时间
        Date date1=Util.changeStringToDate(bicycleRecord.getRent_time());
        Date date2=new Date();
        double time=(date2.getTime()-date1.getTime())/3600000.0;
        double fee=0;
        if(time<1){
            fee=0;
        }else if(1<=time && time<2){
            fee=1;
        }else if(2<=time && time<3){
            fee=2;
        }else if(time>=3){
            fee=Math.ceil(time)*3;
        }

        //校验卡余额是否有余额还车（卡内余额-租车费用>=0）
        double moneyLeft=card.getWallet_money()-fee;
        if(moneyLeft<0){
            return "您卡内余额不足，请先充值再还车,欠费"+moneyLeft+"元";
        }
        //找到车辆租出时的车辆租还记录，补充其还车环节，并将租车佣金写入其中
        bicycleRecord.setReturn_time(Util.changeDateToString(date2));
        bicycleRecord.setReturn_pile_id(pile_id);
        bicycleRecord.setMoney(fee);
        bicycleRecord.setRemark("return bicycle");
        returnBicycleMapper.updateBicycleRecord(bicycleRecord);

        //将还车车桩的状态改成（1：有车）
        BicycleInfo bicycleInfo = returnBicycleMapper.getBicycleInfo(card);
        returnBicycleMapper.updatePile(pile_id,bicycleInfo.getBicycle_code());

        //写业务流水表
        BicycleDeal bicycleDeal=new BicycleDeal();
        bicycleDeal.setCreate_time(Util.changeDateToString(date2));
        bicycleDeal.setDeal_name("return bicycle");
        bicycleDeal.setDeal_type("3");//3代表还入
        bicycleDeal.setRecord_id(bicycleRecord.getRecord_id());
        bicycleDeal.setCard_id(card.getCard_id());
        bicycleDeal.setIs_fee("1");//1代表发生费用
        bicycleDeal.setChg_money(fee);
        bicycleDeal.setFee_type(1);//1代表收入
        bicycleDeal.setBicycle_id(bicycleRecord.getBicycle_id());
        bicycleDeal.setPile_id(bicycleRecord.getRent_pile_id());
//        bicycleDeal.setUser_id();
        returnBicycleMapper.addBicycleDeal(bicycleDeal);

        //修改卡内余额，将（可用余额-租车费用），写入卡内余额
        returnBicycleMapper.updateCardMoney(card,fee);

        //清空车辆信息中的租车卡id
        bicycleInfo.setPile_id(pile_id);
//        bicycleInfo.setUser_id();
        bicycleInfo.setOperator_time(Util.changeDateToString(date2));
        bicycleInfo.setRemark("in pile");
        returnBicycleMapper.updateBicycleInfo(bicycleInfo);

        //将费用计入卡费用流水中，费用类型为3：租车，收支类型为支出，此时将费用计为负数。
        CardRecord cardRecord=new CardRecord();
        cardRecord.setCard_id(card.getCard_id());
        cardRecord.setFee_type(2);
        cardRecord.setChg_monthly_money(0);
        cardRecord.setChg_wallet_money(-fee);
        cardRecord.setChg_frozen_money(0);
        cardRecord.setCreate_time(Util.changeDateToString(date2));
//        cardRecord.setUser_id();
        cardRecord.setRemark("return bicycle");
        cardRecord.setZxbj(0);
        returnBicycleMapper.addCardRecord(cardRecord);
        return "还车成功";
    }






}
