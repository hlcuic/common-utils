package com.hello.designpattern.template;

public class TestDaily {
    public static void main(String[] args) {
        IDailyService service = new WorkerDaily();
        service.start();

        System.out.println("-------------------");
        service = new BossDaily();
        service.start();
    }
}
