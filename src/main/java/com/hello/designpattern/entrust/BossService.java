package com.hello.designpattern.entrust;

public class BossService implements IReceiveTask{

    private WorkerService workerService;

    public BossService(WorkerService workerService){
        this.workerService = workerService;
    }

    @Override
    public void receive(String task) {
        workerService.receive(task);
    }

}
