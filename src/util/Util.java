package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM");
    //得到当前的时间
    public static String getTime(){
        Date date=new Date();
        return format.format(date);
    }

    //时间转换工具
    public static Date changeStringToDate(String time) throws ParseException {
        return format.parse(time);
    }

    public static String changeDateToString(Date date){
        return format.format(date);
    }

    public static Date changeStringToMonth(String date) throws ParseException {return format1.parse(date);}
    public static String changeMonthToString(Date date) {return format1.format(date);}
}
