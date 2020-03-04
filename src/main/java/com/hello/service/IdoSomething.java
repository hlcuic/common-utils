package com.hello.service;

import com.hello.annotation.CheckParamOnMethod;
import com.hello.annotation.CheckParamsOnMethod;
import com.hello.model.Person;

public interface IdoSomething {

    @CheckParamsOnMethod({
        @CheckParamOnMethod(columnName = "identityId", columnDesc = "身份证号", notNull = true, length = {5, 10}),
        @CheckParamOnMethod(columnName = "name", columnDesc = "姓名", notNull = true)}) void doSomething(Person person);
}
