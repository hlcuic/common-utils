package com.hello.model;

import com.hello.annotation.CheckParams;

public class Person {

    @CheckParams(columnName = "身份证号", length = {15, 18}) private Integer identityId;

    @CheckParams(columnName = "姓名", notNull = true) private String name;

    public Person() {

    }

    public Person(Integer identityId, String name) {
        this.identityId = identityId;
        this.name = name;
    }

    public Integer getIdentityId() {
        return identityId;
    }

    public void setIdentityId(Integer identityId) {
        this.identityId = identityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("identityId=").append(identityId);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
