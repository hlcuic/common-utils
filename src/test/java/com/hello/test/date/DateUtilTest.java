package com.hello.test.date;

import com.hello.date.DateUtil;
import org.junit.Test;

import java.util.Date;

public class DateUtilTest {

    /**
     * 查询当月的第一天
     */
    @Test public void testGetFirstDayOfCurrentMonth() {
        Date firstDate = DateUtil.getFirstDayOfCurrentMonth();
        System.out.println("firstDate:" + firstDate);
    }

    /**
     * 查询当月的最后一天
     */
    @Test public void testGetLastDayOfCurrentMonth() {
        Date lastDate = DateUtil.getLastDayOfCurrentMonth();
        System.out.println("lastDate:" + lastDate);
    }

}
