package com.hello.annotation;

public @interface CheckParams {

    String columnName();

    boolean notNull() default false;

    int[] length() default {0, Integer.MAX_VALUE};
}
