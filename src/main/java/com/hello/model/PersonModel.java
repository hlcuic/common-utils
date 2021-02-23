package com.hello.model;

/**
 * @author cuihailong
 * @since 2020/09/30
 */
public class PersonModel {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
