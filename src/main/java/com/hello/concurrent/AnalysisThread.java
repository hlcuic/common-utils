package com.hello.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 分析线程实现的原理
 */
public class AnalysisThread {

    public static void main(String[] args) {
        //      createThreadByExtendsThread();
        //      createThreadByImplementsRunnable();
        createThreadByThreadPool();
    }

    private static void createThreadByExtendsThread() {
        Thread thread = new MyThread();
        //thread.run();
        /**
         * 调用start方法，jvm才会创建线程，分配资源，进入就绪状态，等待分配
         * cpu时间片，分配到资源后就可以执行target的run方法了
         */
        thread.start();
        //thread.start();
    }

    private static void createThreadByImplementsRunnable() {
        Runnable runnable = new MyRunnable();
        /**
         * 这里的runnable作为参数，传给Thread，会
         * 维护在Thread类的target成员变量上，当这个线程
         * 分配到cpu的时间片运行，jvm底层调用run方法时，就会调用target的
         * run方法
         */
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static void createThreadByThreadPool() {
        ExecutorService executors = Executors.newSingleThreadExecutor();
        Runnable runnable = new MyRunnable();
        executors.execute(runnable);
        executors.shutdown();
    }
}

/**
 * 第一种方式，通过继承Thread类创建线程
 */
class MyThread extends Thread {

    @Override public void run() {
        System.out.println(Thread.currentThread().getName() + ".....");
    }
}

/**
 * 第二种方式，通过实现Runnable接口创建线程
 */
class MyRunnable implements Runnable {

    @Override public void run() {
        System.out.println(Thread.currentThread().getName() + ".....");
    }
}

