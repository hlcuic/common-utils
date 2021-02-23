package com.hello.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static com.google.common.collect.ComparisonChain.start;

public class ReadWriterLockDemo {

    private Map<String,String> cacheMap = new HashMap<>();

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    private Lock readLock = lock.readLock();

    private Lock writeLock = lock.writeLock();

    public void put(String key ,String value){
        writeLock.lock();
        try {
            System.out.println("开始执行写入，key: "+key+" ,value: "+value);
            cacheMap.put(key,value);
            System.out.println("结束执行写入，key: "+key+" ,value: "+value);
        }finally {
            writeLock.unlock();
        }
    }

    public String get(String key){
        readLock.lock();
        try{
            System.out.println("开始执行读取，key: "+key);
            String value = cacheMap.get(key);
            System.out.println("结束执行读取，key: "+key+",value: "+value);
            return value;
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriterLockDemo demo = new ReadWriterLockDemo();
        new Thread(()->{
               demo.get("key1");
        }).start();


        new Thread(new Runnable() {
            @Override public void run() {
                demo.put("key1","value1");
            }
        }).start();

        new Thread(new Runnable() {
            @Override public void run() {
                demo.put("key3","value3");
            }
        }).start();

        new Thread(new Runnable() {
            @Override public void run() {
                demo.put("key4","value4");
            }
        }).start();

        new Thread(new Runnable() {
            @Override public void run() {
                demo.get("key3");
            }
        }).start();

    }

}
