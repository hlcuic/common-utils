package com.hello.designpattern.template;

public class BossDaily extends AbstractDailyService{

    @Override
    protected void transfer() {
        System.out.println("开车去上班......");
    }

    @Override
    protected void work() {
        System.out.println("喝茶看报纸......");
    }

}
