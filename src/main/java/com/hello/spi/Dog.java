package com.hello.spi;

public class Dog implements IAnimal {
    @Override
    public void sing() {
        System.out.println("dog sing......");
    }
}
