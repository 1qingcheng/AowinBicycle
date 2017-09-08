package model;

public class CardRecord {
    private int record_id;//记录id，自增
    private int card_id;//卡id
    private int fee_type;//费用类型
    private double chg_monthly_money;//月票变化金额
    private double chg_wallet_money;//钱包变化金额
    private double chg_frozen_money;//冻结变化金额
    private String create_time;//发生时间
    private int user_id;//创建人
    private String remark;//备注
    private int zxbj;//注销标志

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

    public int getFee_type() {
        return fee_type;
    }

    public void setFee_type(int fee_type) {
        this.fee_type = fee_type;
    }

    public double getChg_monthly_money() {
        return chg_monthly_money;
    }

    public void setChg_monthly_money(double chg_monthly_money) {
        this.chg_monthly_money = chg_monthly_money;
    }

    public double getChg_wallet_money() {
        return chg_wallet_money;
    }

    public void setChg_wallet_money(double chg_wallet_money) {
        this.chg_wallet_money = chg_wallet_money;
    }

    public double getChg_frozen_money() {
        return chg_frozen_money;
    }

    public void setChg_frozen_money(double chg_frozen_money) {
        this.chg_frozen_money = chg_frozen_money;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getZxbj() {
        return zxbj;
    }

    public void setZxbj(int zxbj) {
        this.zxbj = zxbj;
    }
}
