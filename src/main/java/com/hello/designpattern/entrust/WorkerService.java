package com.hello.designpattern.entrust;

public class WorkerService implements IReceiveTask{

    @Override
    public void receive(String task) {
        System.out.println("工人开始"+task);
    }
}
