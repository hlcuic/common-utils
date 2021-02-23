package com.hello.spi;

public class Cat implements IAnimal {
    @Override
    public void sing() {
        System.out.println("cat sing......");
    }
}
