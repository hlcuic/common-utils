package com.hello.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class CacheDemo {

    private static Cache<String, String> transactionSessionMapping =
        CacheBuilder.newBuilder().expireAfterWrite(10, TimeUnit.SECONDS).build();

    public static void main(String[] args) {

        transactionSessionMapping.put("1", "aaa");
        transactionSessionMapping.put("2", "bbb");
        System.out.println(transactionSessionMapping.asMap());
        try {
            Thread.sleep(6000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        transactionSessionMapping.put("2", "bbb");
        transactionSessionMapping.getIfPresent("1");

        try {
            Thread.sleep(6000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(transactionSessionMapping.asMap());
        LockSupport.park();

    }
}
