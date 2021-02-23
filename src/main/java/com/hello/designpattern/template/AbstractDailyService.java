package com.hello.designpattern.template;

public abstract class AbstractDailyService implements IDailyService{

    @Override
    public void start(){
        eat();
        transfer();
        work();
    }

    // 共同的方法，吃饭
    public void eat(){
        System.out.println("吃饭.....");
    }

    // 乘坐交通工具，每个方式不一样
    protected abstract void transfer();

    // 每个人工作种类也不一样
    protected abstract void work();

}
