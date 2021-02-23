package com.hello.model;

/**
 * @author cuihailong
 * @since 2020/09/30
 */
public class TestMain {

    public static void main(String[] args) {
        Person person = new Person();
        PersonModel model = new PersonModel();
        model.setName(person.getName());
        System.out.println(model);

        System.out.println();

        person.setName("hello");
        System.out.println(model);
    }
}
