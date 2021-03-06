package com.hello.jvm;

/**
 * VM 参数：-verbose:gc -xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * 对象优先在eden区存放
 */
public class TestAllocation {

    private static final int _1MB = 1024 * 1024;

    /**
     * @param args
     */
    public static void main(String[] args) {
//        byte[] allocation1, allocation2, allocation3, allocation4;
//        allocation1 = new byte[2 * _1MB];
//        allocation2 = new byte[2 * _1MB];
//        allocation3 = new byte[2 * _1MB];
//        allocation4 = new byte[4 * _1MB];   // 出现一次Minor GC
        System.out.println(String.format("%s.%s","111.22","33"));

        System.out.println("结果："+(15324091412428800L>>17));
    }
}
