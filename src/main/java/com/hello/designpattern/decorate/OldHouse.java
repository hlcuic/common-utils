package com.hello.designpattern.decorate;

/**
 * 旧房子原来的光景
 */
public class OldHouse implements IHouse{

    private String person = "一个人";

    private String good = "一张床";

    public void print(){
        System.out.println("person: "+person+",good: "+good );
    }

}
