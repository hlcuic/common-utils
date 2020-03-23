package com.hello.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AnalysisThreadPoolExecutor {

    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newFixedThreadPool(5);
        ExecutorService executorService3 = Executors.newCachedThreadPool();
        //        executorService1.execute();
        //        executorService1.submit();
        String[] arr = new String[10];
        arr[0] = "1";
        System.out.println(arr.length);
        List<String> list = new ArrayList<>();
        list.add("1");
        System.out.println(list.size());
    }
}
