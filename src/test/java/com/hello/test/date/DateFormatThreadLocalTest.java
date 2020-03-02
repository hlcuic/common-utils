package com.hello.test.date;

import com.hello.date.DateFormatThreadLocal;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatThreadLocalTest {

    @Test public void testGetFullDateTimeFormat() {
        SimpleDateFormat simpleDateFormat = DateFormatThreadLocal.getFullDateTimeFormat();
        String currentDate = simpleDateFormat.format(new Date());
        System.out.println(currentDate);
    }

    @Test public void testGetDateTimeFormat() {
        SimpleDateFormat simpleDateFormat = DateFormatThreadLocal.getDateTimeFormat();
        String currentDate = simpleDateFormat.format(new Date());
        System.out.println(currentDate);
    }
}
