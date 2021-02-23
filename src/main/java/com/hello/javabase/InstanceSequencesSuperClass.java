package com.hello.javabase;

public class InstanceSequencesSuperClass {

    private static final String staticVar = "父类静态变量";

    private String normalVar = "父类成员变量";

    static {
        System.out.println("父类静态代码块");
    }

    public InstanceSequencesSuperClass() {
        System.out.println("父类构造函数......");
    }

}
