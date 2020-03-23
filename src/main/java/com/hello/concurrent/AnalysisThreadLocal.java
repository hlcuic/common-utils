package com.hello.concurrent;

import java.text.ParseException;
import java.util.*;

/**
 * 分析ThreadLocal类的实现原理
 * 我们解决线程安全问题，那么以时间换空间，使用锁机制。要么以空间
 * 换时间，使用threadLocal，隔离线程
 */
public class AnalysisThreadLocal {

    private static ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<Map<String, String>>() {
        @Override protected Map<String, String> initialValue() {
            return new HashMap<>();
        }
    };

    public static void main(String[] args) throws ParseException {
        new Thread(() -> {
            threadLocal.get().put("1", "aaaaa");
            String key = threadLocal.get().get("1");
            System.out.println(Thread.currentThread().getName() + " key: " + key);
        }).start();

        new Thread(() -> {
            String key = threadLocal.get().get("1");
            System.out.println(Thread.currentThread().getName() + " key: " + key);
        }).start();

    }
}

