package com.hello.concurrent;

/**
 * 类锁：多个线程访问该类会阻塞，即使访问的是该类的不同实例
 * 但是访问该类的非加锁方法不会阻塞
 * 对象锁：访问同一个类的不同对象不会阻塞，因为锁作用在对象上，但是多个
 * 线程访问同一个对象会阻塞，但是访问非加锁方法不会阻塞。
 */
public class ClassLockObject {

    public static void main(String[] args) {
        TestClassLock model1 = new TestClassLock();
        TestClassLock model2 = new TestClassLock();
        new Thread(()->{
            model1.test();
        },"线程1").start();

        new Thread(()->{
            model2.test1();
        },"线程2").start();
    }

}

class TestClassLock{

    public synchronized static void test(){
        System.out.println(Thread.currentThread().getName()+" start execute.......");
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" end execute.......");
    }

    public static void test1(){
        System.out.println(Thread.currentThread().getName()+" start test1.......");
    }
}
