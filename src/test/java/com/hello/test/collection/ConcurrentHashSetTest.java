package com.hello.test.collection;

import com.hello.collection.ConcurrentHashSet;
import org.junit.Test;

import java.util.Iterator;
import java.util.Set;

public class ConcurrentHashSetTest {

    @Test public void testConcurrentHashSet() {
        Set<String> set = new ConcurrentHashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        System.out.println("size: " + set.size());
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}
