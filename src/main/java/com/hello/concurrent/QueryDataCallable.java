package com.hello.concurrent;

import com.hello.model.Person;

import java.util.concurrent.Callable;

public class QueryDataCallable implements Callable<Person> {

    private int startIndex;

    private int endIndex;

    public QueryDataCallable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override public Person call() throws Exception {
        // 查询数据库逻辑,将开始索引和结束索引带进去查询
        return null;
    }

}
