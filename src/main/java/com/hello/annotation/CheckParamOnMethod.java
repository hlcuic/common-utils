package com.hello.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD) @Retention(RetentionPolicy.RUNTIME) @Documented @Inherited
public @interface CheckParamOnMethod {

    String columnName();

    String columnDesc();

    boolean notNull() default false;

    int[] length() default {0, Integer.MAX_VALUE};
}
