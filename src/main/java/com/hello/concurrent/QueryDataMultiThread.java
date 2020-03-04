package com.hello.concurrent;

import com.hello.model.Person;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class QueryDataMultiThread {

    private static final Logger logger = LoggerFactory.getLogger(QueryDataMultiThread.class);

    /**
     * 使用多线程分页查询大量数据测试
     */
    public static List<Person> queryLargeData() {
        List<Person> personList = new ArrayList<>();
        int threadNum = Runtime.getRuntime().availableProcessors() + 1;
        ExecutorService executors = null;
        try {
            executors = Executors.newFixedThreadPool(threadNum);
            List<Callable<Person>> threadList = wrapCallable();
            List<Future<Person>> futureList = executors.invokeAll(threadList);
            if (futureList != null && !futureList.isEmpty()) {
                for (Future<Person> future : futureList) {
                    Person person = future.get();
                    personList.add(person);
                }
            }
        } catch (Exception e) {
            logger.error("queryLargeData failed: ", e);
        } finally {
            if (null != executors) {
                executors.shutdown();
            }
        }
        return personList;
    }

    private static List<Callable<Person>> wrapCallable() {
        List<Callable<Person>> callableList = new ArrayList();
        // 首先查询出符合条件的数据库总条数，然后分页
        int totalSize = 500001; // 例如数据库满足条件数据50w条,1个线程负责查询10000条
        int pageSize = totalSize / 10000 + 1;
        for (int index = 0; index < pageSize; index++) {
            int start = index * 10000;
            int end = index * 10000 + pageSize;
            Callable<Person> thread = new QueryDataCallable(start, end);
            callableList.add(thread);
        }
        return callableList;
    }

}
