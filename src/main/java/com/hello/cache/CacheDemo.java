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
        transactionSessionMapping.put("2", "bbb");
        System.out.println(transactionSessionMapping.getIfPresent("1"));
        System.out.println(transactionSessionMapping.getIfPresent("3"));


        System.out.println(transactionSessionMapping.asMap());

    }
}
