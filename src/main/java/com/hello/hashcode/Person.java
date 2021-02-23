package com.hello.hashcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Person {
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        Person p1 = new Person();
        p1.setId(1);
        p1.setName("tom");
        set.add(p1);
        Person p2 = new Person();
        p2.setId(1);
        p2.setName("tom");
        set.add(p2);
        System.out.println(set);
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person)o;
        return id == person.id && Objects.equals(name, person.name);
    }

    //    @Override public int hashCode() {
    //        return Objects.hash(id, name);
    //    }
}
