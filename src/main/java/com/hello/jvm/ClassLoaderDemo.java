package com.hello.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * 1:使用类加载器加载类，只能将字节码文件加载到内存
 * 2：使用class.forName,会将字节码文件加载到内存，同时还会执行链接操作，执行static代码块方法
 */
public class ClassLoaderDemo {

    public static void main(String[] args) throws ClassNotFoundException {

        Map<String,String> map = new HashMap<>();
        map.put("1",null);
        System.out.println("map:"+map);

        System.out.println("使用类加载器加载类......");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class clazz = classLoader.loadClass("com.hello.model.Person");
        System.out.println("类加载器加载：clazz:" + clazz.getName());

        System.out.println("------------------");
        System.out.println("------------------");
        System.out.println("使用class.forName加载.........");
        Class clazz2 = Class.forName("com.hello.model.Person");
        System.out.println("class.forName加载：clazz:" + clazz.getName());

    }
}
