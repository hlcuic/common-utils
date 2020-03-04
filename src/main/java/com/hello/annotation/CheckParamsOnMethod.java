package com.hello.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD) @Retention(RetentionPolicy.RUNTIME) @Documented @Inherited
public @interface CheckParamsOnMethod {
    CheckParamOnMethod[] value();
}
