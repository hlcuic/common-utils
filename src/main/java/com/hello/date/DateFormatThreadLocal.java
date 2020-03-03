package com.hello.date;

import java.text.SimpleDateFormat;

/**
 * 类名：日期转换类
 * 描述：因为日期格式化类DateFormat是线程不安全的，
 * 所以使用threadLocal来隔离线程
 */
public class DateFormatThreadLocal {

    private DateFormatThreadLocal() {

    }

    /**
     * 年-月-日 秒:分:时 毫秒
     */
    private static ThreadLocal<SimpleDateFormat> fullDateTimeThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        }
    };

    public static SimpleDateFormat getFullDateTimeFormat() {
        return fullDateTimeThreadLocal.get();
    }

    /**
     * 年-月-日 秒:分:时
     */
    private static ThreadLocal<SimpleDateFormat> dateTimeThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static SimpleDateFormat getDateTimeFormat() {
        return dateTimeThreadLocal.get();
    }

    /**
     * 年月日秒分时
     */
    private static ThreadLocal<SimpleDateFormat> simpleDateTimeThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd HHmmss");
        }
    };

    public static SimpleDateFormat getSimpleDateTimeFormat() {
        return simpleDateTimeThreadLocal.get();
    }

    /**
     * 年-月-日
     */
    private static ThreadLocal<SimpleDateFormat> dateThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static SimpleDateFormat getDateFormat() {
        return dateThreadLocal.get();
    }

    /**
     * 年月日
     */
    private static ThreadLocal<SimpleDateFormat> simpleDateThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    public static SimpleDateFormat getSimpleDateFormat() {
        return simpleDateThreadLocal.get();
    }

    /**
     * 年月
     */
    private static ThreadLocal<SimpleDateFormat> yearMonthThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMM");
        }
    };

    public static SimpleDateFormat getYearMonthDateFormat() {
        return yearMonthThreadLocal.get();
    }

    /**
     * 时:分:秒
     */
    private static ThreadLocal<SimpleDateFormat> timeThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss");
        }
    };

    public static SimpleDateFormat getTimeDateFormat() {
        return timeThreadLocal.get();
    }

    /**
     * 时分秒
     */
    private static ThreadLocal<SimpleDateFormat> simpleTimeThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HHmmss");
        }
    };

    public static SimpleDateFormat getSimpleTimeDateFormat() {
        return simpleTimeThreadLocal.get();
    }

}
