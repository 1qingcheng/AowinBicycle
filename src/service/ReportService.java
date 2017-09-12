package service;

import dao.ReportMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReportService implements ReportInter {
    @Resource
    private ReportMapper reportMapper;

    public ReportMapper getReportMapper() {
        return reportMapper;
    }

    public void setReportMapper(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;
    }

    @Override
    public int getBicycleCount() {
        return reportMapper.getBicycleCount();
    }

    @Override
    public int getRentReturnCount(String minDate,String maxDate) {
        return reportMapper.getRentReturnCount(minDate,maxDate);
    }

    @Override
    public int getRepairCount(String minDate,String maxDate) {
        return reportMapper.getRepairCount(minDate,maxDate);
    }

    @Override
    public double getAvgIncomeByMonth(String minDate, String maxDate) {
        return reportMapper.getAvgIncomeByMonth(minDate,maxDate);
    }

    @Override
    public double getTotalIncomeByMonth(String minDate, String maxDate) {
        return reportMapper.getTotalIncomeByMonth(minDate,maxDate);
    }

    @Override
    public double getRepairAvg(String minDate, String maxDate) {
        return reportMapper.getRepairAvg(minDate,maxDate);
    }

    @Override
    public double getRepairTotal(String minDate, String maxDate) {
        return reportMapper.getRepairTotal(minDate,maxDate);
    }
}
