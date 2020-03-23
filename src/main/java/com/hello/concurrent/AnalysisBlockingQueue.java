package com.hello.concurrent;

import java.util.concurrent.*;

public class AnalysisBlockingQueue {
    public static void main(String[] args) {

        // ArrayBlockingQueue
        //        BlockingQueue blockingQueue = new ArrayBlockingQueue(1000000);
        //        new Thread(new MyProducer(blockingQueue),"producer-thread").start();
        //        new Thread(new MyConsumer(blockingQueue),"consumer-thread").start();

        // LinkedBlockingQueue
        //        BlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

        // PriorityBlockingQueue
        BlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
        new Thread(new MyProducer(priorityBlockingQueue), "producer-thread").start();
        new Thread(new MyConsumer(priorityBlockingQueue), "consumer-thread").start();
    }
}

class MyProducer implements Runnable {

    private BlockingQueue blockingQueue;

    MyProducer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override public void run() {
        int[] arr = {30, 1, 20, 45, 100, 2};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Thread.currentThread() + "正在生产第 " + i + " 个数据");
            blockingQueue.offer(arr[i]);
            //            try {
            //                Thread.sleep(1000L);
            //            } catch (InterruptedException e) {
            //                e.printStackTrace();
            //            }
        }
    }
}

class MyConsumer implements Runnable {

    private BlockingQueue blockingQueue;

    MyConsumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override public void run() {
        while (true) {
            Object obj = blockingQueue.poll();
            System.out.println("正在消费数据 " + obj);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
