package com.hello.concurrent;

/**
 * 线程执行join的时候，必须先start才有效,否则无效
 * 调用join的线程会先执行完
 */
public class JoinDemo {

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" start execute");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" end execute");
        },"线程1");
        t1.start();

        Thread t2 = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" start execute");
            try {
                t1.join();
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" end execute");
        },"线程2");

        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" end execute");
    }
}
