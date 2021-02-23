package com.hello.jvm;

import sun.misc.SharedSecrets;
import sun.misc.VM;

import java.nio.ByteBuffer;

public class DirectAllocationDemo {
    public static void main(String[] args) {
        // 申请直接内存，单位 B
        ByteBuffer.allocateDirect(60 * 1024 * 1024);
        // 运行时可用的最大内存
        System.out.println(Runtime.getRuntime().maxMemory() / 1024.0 / 1024.0);
        // 获取 -XX:MaxDirectMemorySize
        System.out.println(VM.maxDirectMemory() / 1024.0 / 1024.0);
        // NIO 缓存池申请的直接内存大小，也就是 ByteBuffer 申请的内存
        System.out.println(SharedSecrets.getJavaNioAccess().getDirectBufferPool().getTotalCapacity() / 1024.0 / 1024.0);
    }
}
