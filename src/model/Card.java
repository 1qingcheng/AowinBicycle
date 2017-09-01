package model;
//卡
public class Card {
    private int card_id;//卡id，自增
    private String card_code;//卡号
    private int card_type;//卡类型
    private String name;//姓名
    private String idcard;//身份证号
    private String sex;//性别
    private String telphone;//联系电话
    private String mobile;//手机
    private String email;//邮箱
    private String address;//地址
    private String work;//工作单位
    private String zxbj;//注销标志
    private double monthly_money;//月票金额
    private double frozen_money;//冻结金额
    private double wallet_money;//钱包余额
    private int status;//卡状态

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public String getCard_code() {
        return card_code;
    }

    public void setCard_code(String card_code) {
        this.card_code = card_code;
    }

    public int getCard_type() {
        return card_type;
    }

    public void setCard_type(int card_type) {
        this.card_type = card_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getZxbj() {
        return zxbj;
    }

    public void setZxbj(String zxbj) {
        this.zxbj = zxbj;
    }

    public double getMonthly_money() {
        return monthly_money;
    }

    public void setMonthly_money(double monthly_money) {
        this.monthly_money = monthly_money;
    }

    public double getFrozen_money() {
        return frozen_money;
    }

    public void setFrozen_money(double frozen_money) {
        this.frozen_money = frozen_money;
    }

    public double getWallet_money() {
        return wallet_money;
    }

    public void setWallet_money(double wallet_money) {
        this.wallet_money = wallet_money;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}



