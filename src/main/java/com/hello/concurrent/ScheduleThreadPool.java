package com.hello.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        Runnable runnable1 = new MyScheduleRun("1");
        executorService.scheduleAtFixedRate(runnable1, 3L, 1L, TimeUnit.SECONDS);

        Runnable runnable2 = new MyScheduleRun("2");
        executorService.scheduleAtFixedRate(runnable2, 3L, 1L, TimeUnit.SECONDS);

        Runnable runnable3 = new MyScheduleRun("3");
        executorService.scheduleAtFixedRate(runnable3, 3L, 1L, TimeUnit.SECONDS);

        Runnable runnable4 = new MyScheduleRun("4");
        executorService.scheduleAtFixedRate(runnable4, 3L, 1L, TimeUnit.SECONDS);
    }

    static class MyScheduleRun implements Runnable{

        private String name;

        MyScheduleRun(String name){
            this.name = name;
        }

        @Override
        public void run() {
            if("3".equals(name)){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name);
        }
    }

}
