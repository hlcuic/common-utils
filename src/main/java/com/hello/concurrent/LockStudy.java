package com.hello.concurrent;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockStudy {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            System.out.println("线程t1执行任务......");
            LockSupport.park();
            System.out.println("线程t1执行任务完成......");
        }, "线程t1");
        t1.start();

        //        Thread t2 = new Thread(()->{
        //            System.out.println("线程t2执行任务......");
        //        },"线程t2");
        //        t2.start();
        Thread.sleep(3000L);
        LockSupport.unpark(t1);
        System.out.println(".......");

        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println("do something......");
        } finally {
            lock.unlock();
        }
    }
}
