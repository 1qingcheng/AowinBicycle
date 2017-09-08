package dao;

import model.*;
import org.apache.ibatis.annotations.Param;

public interface RentBicycleMapper {

    Card verifyCardCode(String card_code);//根据卡编码验证是否该卡存在

    double verifyCardMoney(Card card);//根据卡编码验证卡金额是否满足条件  (冻结金额+钱包余额)>=200

    BicycleInfo verifyAlreadyRent(Card card);//根据卡编码验证是否已经租车

    int updateBicycleInfo(@Param("card")Card card,@Param("pile_id")int pile_id);//将该车辆的车桩编号改成null。车辆信息中租车卡号填写租车卡编号。

    int updatePileStatus(int pile_id);     //车辆租出后将车桩状态改成2：无车

    double queryFrozenMoney(Card card);//查询卡下的冻结金额

    int updateFrozenMoney(@Param("money") double money,@Param("card") Card card);//划拨冻结金额

    int addCardRecord(CardRecord cardRecord);//划拨冻结金额后新增一条卡金额变动记录
    int addBicycleRecord(BicycleRecord bicycleRecord);//需要在车辆租还记录表中增加一条租车记录。
    int addBicycleDeal(BicycleDeal bicycleDeal);//新增车辆业务流水表记录

}
