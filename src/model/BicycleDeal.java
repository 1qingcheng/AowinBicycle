package model;
//车辆业务流水表
public class BicycleDeal {
    private int deal_id;//业务id,自增
    private String create_time;//发生时间
    private String deal_name;//业务名称
    private String deal_type;//业务类型
    private int record_id;//关联的业务记录id
    private int card_id;//业务卡id
    private String is_fee;//是否发生费用
    private double chg_money;//费用金额
    private int fee_type;//费用收支类型
    private int bicycle_id;//车辆ID
    private int pile_id;//车桩ID
    private int user_id;//操作人

    public int getDeal_id() {
        return deal_id;
    }

    public void setDeal_id(int deal_id) {
        this.deal_id = deal_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getDeal_name() {
        return deal_name;
    }

    public void setDeal_name(String deal_name) {
        this.deal_name = deal_name;
    }

    public String getDeal_type() {
        return deal_type;
    }

    public void setDeal_type(String deal_type) {
        this.deal_type = deal_type;
    }

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public String getIs_fee() {
        return is_fee;
    }

    public void setIs_fee(String is_fee) {
        this.is_fee = is_fee;
    }

    public double getChg_money() {
        return chg_money;
    }

    public void setChg_money(double chg_money) {
        this.chg_money = chg_money;
    }

    public int getFee_type() {
        return fee_type;
    }

    public void setFee_type(int fee_type) {
        this.fee_type = fee_type;
    }

    public int getBicycle_id() {
        return bicycle_id;
    }

    public void setBicycle_id(int bicycle_id) {
        this.bicycle_id = bicycle_id;
    }

    public int getPile_id() {
        return pile_id;
    }

    public void setPile_id(int pile_id) {
        this.pile_id = pile_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
