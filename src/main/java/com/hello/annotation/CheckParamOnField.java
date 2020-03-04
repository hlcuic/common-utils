package com.hello.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD) @Retention(RetentionPolicy.RUNTIME) @Documented @Inherited
public @interface CheckParamOnField {

    String columnName();

    boolean notNull() default false;

    int[] length() default {0, Integer.MAX_VALUE};
}
