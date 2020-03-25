package com.hello.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockStudy {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.remove(2);
        System.out.println(list.get(2));
        //        try{
        //            new Thread(()->{
        //                int i = 10/0;
        //            }).start();
        //            System.out.println("end......");
        //        }catch (Exception e){
        //            e.printStackTrace();
        //        }

        //        CountDownLatch latch = new CountDownLatch(2);
        //        Thread t1 = new Thread(() -> {
        //            System.out.println("线程t1开始执行任务......");
        //          test();
        //            latch.countDown();
        //        }, "线程t1");
        //        t1.start();
        //
        //        Thread t2 = new Thread(()->{
        //            System.out.println("线程t2开始执行任务......");
        ////          test();
        //            try {
        //                Thread.sleep(3000L);
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //            }
        //            latch.countDown();
        //            try {
        //                latch.await();
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //            }
        //        },"线程t2");
        //        t2.start();
        //
        //        try {
        //            latch.await();
        //            System.out.println("main after await......");
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }

    }

    private static void test() {
        lock.lock();
        try {
            lock.lock();
            try {
                Thread.sleep(3000L);
                synchronized (LockStudy.class) {
                    System.out.println(Thread.holdsLock(LockStudy.class));
                    Thread.getAllStackTraces();
                }
                System.out.println(Thread.currentThread().getName() + " do something......");
            } finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static void test2() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(5);

        latch.countDown();

        latch.await();

        latch.await();
        Thread.interrupted();
    }

}

