package com.hello.designpattern.decorate;

public class TestDecorate {
    public static void main(String[] args) {
        // 2010 年家里的旧房光景
        IHouse house = new OldHouse();
        house.print();

        System.out.println("10年后------------------------------------");
        // 2020 年装修后新房
        house = new NewHouse(house);
        house.print();
    }
}
