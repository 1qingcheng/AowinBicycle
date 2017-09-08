package dao;

import model.*;
import org.apache.ibatis.annotations.Param;

public interface ReturnBicycleMapper {
    BicycleRecord getBicycleRecord(Card card);//根据卡号查询得到BicycleRecord
    BicycleInfo getBicycleInfo(Card card);//根据卡号查询得到BicycleInfo
    int updateBicycleRecord(BicycleRecord bicycleRecord);//还车后补全租车记录
    int updatePile(@Param("pile_id") int pile_id,@Param("bicycle_code") String bicycle_code);//将还车车桩的状态改成（1：有车）
    int addBicycleDeal(BicycleDeal bicycleDeal);//还车后新增流水记录
    int updateCardMoney(@Param("card") Card card,@Param("fee") double fee);//还车后修改卡内余额
    int updateBicycleInfo(BicycleInfo bicycleInfo);//清空车辆信息中的租车卡id
    int addCardRecord(CardRecord cardRecord);//将费用计入卡费用流水中，费用类型为3：租车，收支类型为支出，此时将费用计为负数。




}
