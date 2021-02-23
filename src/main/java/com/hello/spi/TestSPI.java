package com.hello.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class TestSPI {
    public static void main(String[] args) {
        ServiceLoader<IAnimal> animals = ServiceLoader.load(IAnimal.class);
        for (Iterator<IAnimal> iter = animals.iterator();iter.hasNext();) {
            IAnimal animal = iter.next();
            animal.sing();
        }
    }
}
