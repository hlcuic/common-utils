package com.hello.collection;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 类名：并发集合Set
 * 描述：利用ConcurrentHashMap类实现存储单个元素的集合，并且保证线程安全
 *
 * @param <E>
 */
public class ConcurrentHashSet<E> extends AbstractSet<E> implements Serializable {

    private static final long serialVersionId = 1L;

    private final Map<E, Object> map = new ConcurrentHashMap<>();

    public boolean add(E e) {
        return null != ((ConcurrentMap<E, Object>)map).putIfAbsent(e, Boolean.TRUE);
    }

    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    public int size() {
        return map.size();
    }

}
