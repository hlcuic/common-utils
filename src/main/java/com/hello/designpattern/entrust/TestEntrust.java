package com.hello.designpattern.entrust;

public class TestEntrust {
    public static void main(String[] args) {
        String task = "搬砖";
        WorkerService workerService = new WorkerService();
        BossService bossService = new BossService(workerService);
        bossService.receive(task);
    }
}
