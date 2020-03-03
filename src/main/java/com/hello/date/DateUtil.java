package com.hello.date;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private DateUtil() {

    }

    /**
     * 获取当月第一天日期
     *
     * @return
     */
    public static Date getFirstDayOfCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        // 加上设置月的参数，就是当年的第一天
        //calendar.set(Calendar.MONTH,calendar.getActualMinimum(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date date = calendar.getTime();
        System.out.println("date:" + date);
        return date;
    }

    /**
     * 获取当月最后一天日期
     *
     * @return
     */
    public static Date getLastDayOfCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        // 加上设置月的参数，就是当年的最后一天
        calendar.set(Calendar.MONTH, calendar.getActualMaximum(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date date = calendar.getTime();
        System.out.println("date:" + date);
        return date;
    }

}
