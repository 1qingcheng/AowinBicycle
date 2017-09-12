package model;

import java.util.List;

//车辆车点
public class BicycleStation {

    private int station_id;//车点id,自增
    private String station_code;//车点编号
    private String station_name;//车点名称
    private double longitude;//车点经度
    private double latitude;//车点纬度
    private double bicycle_pile_num;//车点车桩数量
    private String address;//地址
    private String person_in_charge;//负责人
    private String build_time;//新建日期
    private String run_time;//运行日期
    private int user_id;//操作人
    private String create_time;//创建时间
    private String remark;//备注
    private String zxbj;//注销标记
    private List<BicyclePile> bicyclePile;//车点上的车桩集合


    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public String getStation_code() {
        return station_code;
    }

    public void setStation_code(String station_code) {
        this.station_code = station_code;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getBicycle_pile_num() {
        return bicycle_pile_num;
    }

    public void setBicycle_pile_num(double bicycle_pile_num) {
        this.bicycle_pile_num = bicycle_pile_num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPerson_in_charge() {
        return person_in_charge;
    }

    public void setPerson_in_charge(String person_in_charge) {
        this.person_in_charge = person_in_charge;
    }

    public String getBuild_time() {
        return build_time;
    }

    public void setBuild_time(String build_time) {
        this.build_time = build_time;
    }

    public String getRun_time() {
        return run_time;
    }

    public void setRun_time(String run_time) {
        this.run_time = run_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getZxbj() {
        return zxbj;
    }

    public void setZxbj(String zxbj) {
        this.zxbj = zxbj;
    }

    public List<BicyclePile> getBicyclePile() {
        return bicyclePile;
    }

    public void setBicyclePile(List<BicyclePile> bicyclePile) {
        this.bicyclePile = bicyclePile;
    }
}
