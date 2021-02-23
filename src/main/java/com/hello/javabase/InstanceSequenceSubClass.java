package com.hello.javabase;

public class InstanceSequenceSubClass extends InstanceSequencesSuperClass{

    private static final String staticVar = "子类静态变量";

    private String normalVar = "子类成员变量";

    static{
        System.out.println("子类静态代码块");
    }

    public InstanceSequenceSubClass(){
        System.out.println("子类构造函数......");
    }

    public static void main(String[] args) {
        new InstanceSequenceSubClass();
    }

}
