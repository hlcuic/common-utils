package com.hello.service.impl;

import com.hello.model.Person;
import com.hello.service.IdoSomething;

public class DoSomethingServiceImpl implements IdoSomething {

    /**
     * 对该方法做动态代理，校验参数
     *
     * @param person
     */
    @Override public void doSomething(Person person) {
        System.out.println("do something...");
    }

}
