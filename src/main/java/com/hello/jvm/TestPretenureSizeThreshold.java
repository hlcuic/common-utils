package com.hello.jvm;

/**
 * 大对象直接进入老年代
 */
public class TestPretenureSizeThreshold {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation;
        allocation = new byte[6 * _1MB];
    }
}
