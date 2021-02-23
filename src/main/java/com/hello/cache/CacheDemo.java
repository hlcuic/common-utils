package com.hello.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CacheDemo {

    private static Cache<String, String> transactionSessionMapping =
        CacheBuilder.newBuilder().expireAfterWrite(3, TimeUnit.SECONDS).build();

    public static void main(String[] args) throws InterruptedException {

        transactionSessionMapping.put("1", "aaa");
        transactionSessionMapping.put("2", "bbb");
        System.out.println(transactionSessionMapping.asMap());
        transactionSessionMapping.put("2", "bbb");
        System.out.println(transactionSessionMapping.getIfPresent("1"));
        System.out.println(transactionSessionMapping.getIfPresent("3"));


        Thread.sleep(3000L);
        Map<String,String> map = transactionSessionMapping.asMap();
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(transactionSessionMapping.size());

    }
}
