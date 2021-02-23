package com.hello.designpattern.template;

public class WorkerDaily extends AbstractDailyService{

    @Override
    protected void transfer() {
        System.out.println("坐公交去上班......");
    }

    @Override
    protected void work() {
        System.out.println("开始搬砖......");
    }

}
