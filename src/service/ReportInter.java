package service;


public interface ReportInter {
    int getBicycleCount();//车辆数量统计
    int getRentReturnCount(String minDate,String maxDate);//借还次数
    int getRepairCount(String minDate,String maxDate);//修理次数
    double getAvgIncomeByMonth(String minDate, String maxDate);//当月平均租车收入
    double getTotalIncomeByMonth(String minDate, String maxDate);//当月总租车收入
    double getRepairAvg(String minDate, String maxDate);//当月平均修车费用
    double getRepairTotal(String minDate, String maxDate);//当月总修车费用

}
