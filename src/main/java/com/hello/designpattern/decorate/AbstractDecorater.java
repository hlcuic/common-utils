package com.hello.designpattern.decorate;

/**
 * 装饰器
 */
public abstract class AbstractDecorater implements IHouse{

    protected IHouse house;

    public AbstractDecorater(IHouse house){
        this.house = house;
    }
}
