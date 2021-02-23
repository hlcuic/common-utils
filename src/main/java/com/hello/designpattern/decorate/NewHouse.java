package com.hello.designpattern.decorate;

public class NewHouse extends AbstractDecorater{

    private String person = "多了一个老婆";

    private String goods = "买了一些家具";

    public NewHouse(IHouse house) {
        super(house);
    }

    public void print(){
        house.print();
        System.out.print("person: "+person+", goods: "+goods);
    }

}
