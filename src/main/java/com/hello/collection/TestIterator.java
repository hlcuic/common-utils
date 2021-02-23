package com.hello.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TestIterator {

    public static void main(String[] args) {
//        Long key = 1L;
//        key += 1L;
//        System.out.println(key);
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("5");
//        list.add("3");
//        System.out.println(list);
//        Collections.sort(list);
//        System.out.println(list);

//        int[] src = {1,2,3};
//        int[] dest = Arrays.copyOf(src, src.length + 1);
//        System.out.println(Arrays.toString(src));
//        System.out.println(Arrays.toString(dest));

        List<Student> list = Arrays.asList(new Student(1, "one"), new Student(2, "two"), new Student(3, "tree"));
        //从list集合中，取出字段id的列表
        List<Integer> names = list.stream().map(Student::getId).collect(Collectors.toList());
        int idSum = list.stream().mapToInt(Student::getId).sum();
        System.out.println(idSum);
    }

    private static class Student{
        private Integer id;
        private String name;
        Student(Integer id,String name){
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
