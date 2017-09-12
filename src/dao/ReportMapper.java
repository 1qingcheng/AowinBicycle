package dao;

import org.apache.ibatis.annotations.Param;

public interface ReportMapper {
    int getBicycleCount();//车辆数量统计
    int getRentReturnCount(@Param("minDate") String minDate,@Param("maxDate") String maxDate);//借还次数
    int getRepairCount(@Param("minDate") String minDate,@Param("maxDate") String maxDate);//修理次数
    double getAvgIncomeByMonth(@Param("minDate") String minDate,@Param("maxDate") String maxDate);//当月平均收入
    double getTotalIncomeByMonth(@Param("minDate") String minDate,@Param("maxDate") String maxDate);//当月总租车收入
    double getRepairAvg(@Param("minDate") String minDate,@Param("maxDate") String maxDate);//当月平均修车费用
    double getRepairTotal(@Param("minDate") String minDate,@Param("maxDate") String maxDate);//当月总修车费用

}
