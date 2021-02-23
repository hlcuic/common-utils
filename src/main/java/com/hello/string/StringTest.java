package com.hello.string;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "123";
        String s3 = new String("123");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}
